package com.liferay.docs.guestbook.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;


public class GuestbookFinderUtil {
    private static GuestbookFinder _finder;

    public static java.util.List<com.liferay.docs.guestbook.model.Guestbook> buscarPorNombre(
        java.lang.String name, int begin, int end) {
        return getFinder().buscarPorNombre(name, begin, end);
    }

    public static GuestbookFinder getFinder() {
        if (_finder == null) {
            _finder = (GuestbookFinder) PortletBeanLocatorUtil.locate(com.liferay.docs.guestbook.service.ClpSerializer.getServletContextName(),
                    GuestbookFinder.class.getName());

            ReferenceRegistry.registerReference(GuestbookFinderUtil.class,
                "_finder");
        }

        return _finder;
    }

    public void setFinder(GuestbookFinder finder) {
        _finder = finder;

        ReferenceRegistry.registerReference(GuestbookFinderUtil.class, "_finder");
    }
}
