package com.liferay.docs.guestbook.service.persistence;

public interface GuestbookFinder {
    public java.util.List<com.liferay.docs.guestbook.model.Guestbook> buscarPorNombre(
        java.lang.String name, int begin, int end);
}
