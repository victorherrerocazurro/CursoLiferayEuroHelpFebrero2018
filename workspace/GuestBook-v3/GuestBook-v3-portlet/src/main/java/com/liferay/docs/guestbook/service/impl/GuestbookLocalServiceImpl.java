package com.liferay.docs.guestbook.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.docs.guestbook.GuestbookNameException;
import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.base.GuestbookLocalServiceBaseImpl;
import com.liferay.docs.guestbook.service.persistence.GuestbookFinderUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the guestbook local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.docs.guestbook.service.GuestbookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.docs.guestbook.service.base.GuestbookLocalServiceBaseImpl
 * @see com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil
 */
public class GuestbookLocalServiceImpl extends GuestbookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil} to access
	 * the guestbook local service.
	 */
	public List<Guestbook> getGuestbooks(long groupId) throws SystemException {
		return guestbookPersistence.findByGroupId(groupId);
	}

	public List<Guestbook> getGuestbooks(long groupId, int start, int end) throws SystemException {
		return guestbookPersistence.findByGroupId(groupId, start, end);
	}
	
	protected void validate(String name) throws PortalException {
	    if (Validator.isNull(name)) {
	       throw new GuestbookNameException();
	    }
	}
	
	//Será necesario recibir el ServiceContext, para obtener informacion relativa al Scope de ejecucion,
	//en este caso el GroupId o Uuid
	public Guestbook addGuestbook(long userId, String name, ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();

		User user = userPersistence.findByPrimaryKey(userId);

		Date now = new Date();

		validate(name);

		//Obtencion del siguiente valor valido de la clave primaria para un Guestbook
		long guestbookId = counterLocalService.increment();

		//Creación del objeto con la PK, pero todavia no persistente, es una factoria
		Guestbook guestbook = guestbookPersistence.create(guestbookId);

		guestbook.setUuid(serviceContext.getUuid());
		guestbook.setUserId(userId);
		guestbook.setGroupId(groupId);
		guestbook.setCompanyId(user.getCompanyId());
		guestbook.setUserName(user.getFullName());
		guestbook.setCreateDate(serviceContext.getCreateDate(now));
		guestbook.setModifiedDate(serviceContext.getModifiedDate(now));
		guestbook.setName(name);
		guestbook.setExpandoBridgeAttributes(serviceContext);

		//Actualiza la entidad en la BD o la inserta si no existe.
		guestbookPersistence.update(guestbook);

		//Habilita los permisos sobre los registros insertados
		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
			       Guestbook.class.getName(), guestbookId, false, true, true);
		
		return guestbook;
	}
	
	public List<Guestbook> buscarPorNombre(String name, int begin, int end) {
		return GuestbookFinderUtil.buscarPorNombre(name, begin, end);
	}
}
