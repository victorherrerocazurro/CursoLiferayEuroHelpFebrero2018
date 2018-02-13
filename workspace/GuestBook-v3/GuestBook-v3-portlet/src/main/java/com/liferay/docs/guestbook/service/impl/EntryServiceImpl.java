package com.liferay.docs.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.docs.guestbook.EntryEmailException;
import com.liferay.docs.guestbook.EntryMessageException;
import com.liferay.docs.guestbook.EntryNameException;
import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.base.EntryServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;

/**
 * The implementation of the entry remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.docs.guestbook.service.EntryService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.guestbook.service.base.EntryServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.EntryServiceUtil
 */
public class EntryServiceImpl extends EntryServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.liferay.docs.guestbook.service.EntryServiceUtil} to access the entry remote service.
     */
	public List<Entry> getEntries(long groupId, long guestbookId) throws SystemException {
		return entryLocalService.getEntries(groupId, guestbookId);

	}

	public List<Entry> getEntries(long groupId, long guestbookId, int start, int end) throws SystemException {
		return entryLocalService.getEntries(groupId, guestbookId, start, end);

	}
	
	public Entry addEntry(long userId, long guestbookId, String name, String email, String message,
			ServiceContext serviceContext) throws PortalException, SystemException {
		return entryLocalService.addEntry(userId, guestbookId, name, email, message, serviceContext);

	}

	public Entry deleteEntry(long entryId, ServiceContext serviceContext) throws PortalException, SystemException {

		return entryLocalService.deleteEntry(entryId, serviceContext);
	}

	public Entry updateEntry(long userId, long guestbookId, long entryId, String name, String email, String message,
			ServiceContext serviceContext) throws PortalException, SystemException {
		return entryLocalService.updateEntry(userId, guestbookId, entryId, name, email, message, serviceContext);
		
	}
}
