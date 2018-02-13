package com.liferay.docs.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.docs.guestbook.EntryEmailException;
import com.liferay.docs.guestbook.EntryMessageException;
import com.liferay.docs.guestbook.EntryNameException;
import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.base.EntryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.docs.guestbook.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.guestbook.service.base.EntryLocalServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.EntryLocalServiceUtil
 */
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.docs.guestbook.service.EntryLocalServiceUtil} to access the
	 * entry local service.
	 */
	public List<Entry> getEntries(long groupId, long guestbookId) throws SystemException {

		return entryPersistence.findByG_G(groupId, guestbookId);
	}

	public List<Entry> getEntries(long groupId, long guestbookId, int start, int end) throws SystemException {

		return entryPersistence.findByG_G(groupId, guestbookId, start, end);
	}

	protected void validate(String name, String email, String entry) throws PortalException {
		if (Validator.isNull(name)) {
			throw new EntryNameException();
		}

		if (!Validator.isEmailAddress(email)) {
			throw new EntryEmailException();
		}

		if (Validator.isNull(entry)) {
			throw new EntryMessageException();
		}
	}

	public Entry addEntry(long userId, long guestbookId, String name, String email, String message,
			ServiceContext serviceContext) throws PortalException, SystemException {
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name, email, message);

		long entryId = counterLocalService.increment();

		Entry entry = entryPersistence.create(entryId);

		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setExpandoBridgeAttributes(serviceContext);
		entry.setGuestbookId(guestbookId);
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);

		entryPersistence.update(entry);

		// Habilita los permisos sobre los registros insertados
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, Entry.class.getName(), entryId, false,
				true, true);

		// Habilita las funcionalidades de Assets
		assetEntryLocalService.updateEntry(userId, groupId, entry.getCreateDate(), entry.getModifiedDate(),
				Entry.class.getName(), entryId, entry.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null, ContentTypes.TEXT_HTML, entry.getName(),
				entry.getMessage(), entry.getMessage(), null, null, 0, 0, null, false);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Entry.class.getName(), entryId);

		// Se encarga de persistir los Assets con los que se haya enlazado este
		// Entry
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		updateEntryIndexer(entry, false);
		
		return entry;

	}

	public Entry deleteEntry(long entryId, ServiceContext serviceContext) throws PortalException, SystemException {

		Entry entry = getEntry(entryId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(), Entry.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, entryId);

		assetEntryLocalService.deleteEntry(Entry.class.getName(), entryId);

		assetLinkLocalService.deleteLinks(entryId);

		entry = deleteEntry(entryId);

		updateEntryIndexer(entry, true);
		
		return entry;
	}

	public Entry updateEntry(long userId, long guestbookId, long entryId, String name, String email, String message,
			ServiceContext serviceContext) throws PortalException, SystemException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name, email, message);

		Entry entry = getEntry(entryId);

		entry.setUserId(userId);
		entry.setUserName(user.getFullName());
		entry.setName(name);
		entry.setEmail(email);
		entry.setMessage(message);
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		entry.setExpandoBridgeAttributes(serviceContext);

		entryPersistence.update(entry);

		resourceLocalService.updateResources(user.getCompanyId(), groupId, Entry.class.getName(), entryId,
				serviceContext.getGroupPermissions(), serviceContext.getGuestPermissions());

		// Habilita las funcionalidades de Assets
		// assetEntryLocalService.updateEntry(Entry.class.getName(), entryId,
		// new Date(), true);

		assetEntryLocalService.updateEntry(userId, groupId, entry.getCreateDate(), entry.getModifiedDate(),
				Entry.class.getName(), entryId, entry.getUuid(), 0, serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null, ContentTypes.TEXT_HTML, entry.getName(),
				entry.getMessage(), entry.getMessage(), null, null, 0, 0, null, false);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(Entry.class.getName(), entryId);

		// Se encarga de persistir los Assets con los que se haya enlazado este
		// Entry
		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		updateEntryIndexer(entry, false);
		
		return entry;
	}

	private void updateEntryIndexer(Entry entry, boolean delete) throws SearchException {

		Indexer indexer = IndexerRegistryUtil.nullSafeGetIndexer(Entry.class.getName());

		if (delete) {
			indexer.delete(entry);
		} else {
			indexer.reindex(entry);
		}
	}

}
