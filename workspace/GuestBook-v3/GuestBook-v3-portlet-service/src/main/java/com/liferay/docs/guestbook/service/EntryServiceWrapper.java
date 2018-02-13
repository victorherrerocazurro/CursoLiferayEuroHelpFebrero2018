package com.liferay.docs.guestbook.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EntryService}.
 *
 * @author Brian Wing Shun Chan
 * @see EntryService
 * @generated
 */
public class EntryServiceWrapper implements EntryService,
    ServiceWrapper<EntryService> {
    private EntryService _entryService;

    public EntryServiceWrapper(EntryService entryService) {
        _entryService = entryService;
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _entryService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _entryService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _entryService.invokeMethod(name, parameterTypes, arguments);
    }

    @Override
    public java.util.List<com.liferay.docs.guestbook.model.Entry> getEntries(
        long groupId, long guestbookId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entryService.getEntries(groupId, guestbookId);
    }

    @Override
    public java.util.List<com.liferay.docs.guestbook.model.Entry> getEntries(
        long groupId, long guestbookId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _entryService.getEntries(groupId, guestbookId, start, end);
    }

    @Override
    public com.liferay.docs.guestbook.model.Entry addEntry(long userId,
        long guestbookId, java.lang.String name, java.lang.String email,
        java.lang.String message,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _entryService.addEntry(userId, guestbookId, name, email,
            message, serviceContext);
    }

    @Override
    public com.liferay.docs.guestbook.model.Entry deleteEntry(long entryId,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _entryService.deleteEntry(entryId, serviceContext);
    }

    @Override
    public com.liferay.docs.guestbook.model.Entry updateEntry(long userId,
        long guestbookId, long entryId, java.lang.String name,
        java.lang.String email, java.lang.String message,
        com.liferay.portal.service.ServiceContext serviceContext)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _entryService.updateEntry(userId, guestbookId, entryId, name,
            email, message, serviceContext);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public EntryService getWrappedEntryService() {
        return _entryService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedEntryService(EntryService entryService) {
        _entryService = entryService;
    }

    @Override
    public EntryService getWrappedService() {
        return _entryService;
    }

    @Override
    public void setWrappedService(EntryService entryService) {
        _entryService = entryService;
    }
}
