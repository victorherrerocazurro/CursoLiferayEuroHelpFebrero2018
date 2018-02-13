package com.liferay.docs.guestbook.assets;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.service.permission.EntryPermission;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.asset.model.BaseAssetRenderer;

public class EntryAssetRenderer extends BaseAssetRenderer {

	private Entry _entry;

	//Como encapsula una registro de tipo Entry, para poder pintarlo de forma generica como Asset, pues recibe
	//por parametro una instancia de Entry
	public EntryAssetRenderer(Entry entry) {
		_entry = entry;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {

		long entryId = _entry.getEntryId();

		boolean contains = false;

		try {
			contains = EntryPermission.contains(permissionChecker, entryId, ActionKeys.UPDATE);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}

		return contains;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {

		long entryId = _entry.getEntryId();

		boolean contains = false;

		try {
			contains = EntryPermission.contains(permissionChecker, entryId, ActionKeys.VIEW);
		} catch (PortalException pe) {
			_log.error(pe.getLocalizedMessage());
		} catch (SystemException se) {
			_log.error(se.getLocalizedMessage());
		}

		return contains;
	}
	
	//Get de los campos de tipo Asset

	@Override
	public String getSummary(Locale locale) {
		return "Name: " + _entry.getName() + ". Message: " + _entry.getMessage();
	}

	@Override
	public String getTitle(Locale locale) {
		return _entry.getMessage();
	}
	
	//Get de los campos recomendados/comunes a todos las entidades de Liferay
	
	@Override
	public String getClassName() {
		return Entry.class.getName();
	}

	@Override
	public long getClassPK() {
		return _entry.getEntryId();
	}

	@Override
	public long getGroupId() {
		return _entry.getGroupId();
	}

	@Override
	public long getUserId() {
		return _entry.getUserId();
	}

	@Override
	public String getUserName() {
		return _entry.getUserName();
	}

	@Override
	public String getUuid() {
		return _entry.getUuid();
	}

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse, String template) throws Exception {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			renderRequest.setAttribute("gb_entry", _entry);

			return "/html/guestbook/" + template + ".jsp";
		} else {
			return null;
		}
	}

	private Log _log;

}
