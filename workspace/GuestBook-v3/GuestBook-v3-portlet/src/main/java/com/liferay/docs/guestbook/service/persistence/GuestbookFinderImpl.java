package com.liferay.docs.guestbook.service.persistence;

import java.util.List;

import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.model.impl.GuestbookImpl;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

public class GuestbookFinderImpl extends BasePersistenceImpl<Guestbook> implements GuestbookFinder {

	public static final String FIND_BY_NOMBRE = GuestbookFinder.class.getName()
			+ ".buscarPorNombre";
	
	public List<Guestbook> buscarPorNombre(String name, int begin, int end) {

		Session session = null;
		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_NOMBRE);

			SQLQuery q = session.createSQLQuery(sql);
			q.setCacheable(false);
			q.addEntity("GB_Guestbook", GuestbookImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(name);
			
			//q.list();
			
			return (List<Guestbook>) QueryUtil.list(q, getDialect(), begin, end);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return null;
	}
}
