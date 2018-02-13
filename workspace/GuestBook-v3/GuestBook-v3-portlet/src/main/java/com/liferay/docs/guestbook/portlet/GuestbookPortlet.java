package com.liferay.docs.guestbook.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.docs.guestbook.model.Entry;
import com.liferay.docs.guestbook.model.Guestbook;
import com.liferay.docs.guestbook.service.EntryLocalServiceUtil;
import com.liferay.docs.guestbook.service.GuestbookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GuestBookPortlet
 */
public class GuestbookPortlet extends MVCPortlet {

	// Sobreescritura del metodo render, para controlar que info le llega a la
	// fase de render, como se renderiza se sigue realizando con el framework
	// MvcPortlet
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Guestbook.class.getName(), renderRequest);

			long groupId = serviceContext.getScopeGroupId();

			long guestbookId = ParamUtil.getLong(renderRequest, "guestbookId");

			List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(groupId);

			if (guestbooks.size() == 0) {
				Guestbook guestbook = GuestbookLocalServiceUtil.addGuestbook(serviceContext.getUserId(), "Main",
						serviceContext);

				guestbookId = guestbook.getGuestbookId();

			}

			if (!(guestbookId > 0)) {
				guestbookId = guestbooks.get(0).getGuestbookId();
			}

			renderRequest.setAttribute("guestbookId", guestbookId);

		} catch (Exception e) {

			throw new PortletException(e);
		}

		super.render(renderRequest, renderResponse);

	}

	public void addEntry(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Entry.class.getName(), request);

		String userName = ParamUtil.getString(request, "name");
		String email = ParamUtil.getString(request, "email");
		String message = ParamUtil.getString(request, "message");
		long guestbookId = ParamUtil.getLong(request, "guestbookId");
		long entryId = ParamUtil.getLong(request, "entryId");

		if (entryId > 0) {

			try {

				EntryLocalServiceUtil.updateEntry(serviceContext.getUserId(), guestbookId, entryId, userName, email,
						message, serviceContext);

				SessionMessages.add(request, "entryAdded");

				response.setRenderParameter("guestbookId", Long.toString(guestbookId));

			} catch (Exception e) {

				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath", "/html/guestbook/edit_entry.jsp");
			}

		} else {

			try {
				EntryLocalServiceUtil.addEntry(serviceContext.getUserId(), guestbookId, userName, email, message,
						serviceContext);

				SessionMessages.add(request, "entryAdded");

				response.setRenderParameter("guestbookId", Long.toString(guestbookId));

			} catch (Exception e) {
				SessionErrors.add(request, e.getClass().getName());

				PortalUtil.copyRequestParameters(request, response);

				response.setRenderParameter("mvcPath", "/html/guestbook/edit_entry.jsp");
			}
		}

	}

	/*
	 * try { EntryLocalServiceUtil.addEntry(serviceContext.getUserId(),
	 * guestbookId, userName, email, message, serviceContext);
	 * 
	 * SessionMessages.add(request, "entryAdded");
	 * 
	 * response.setRenderParameter("guestbookId", Long.toString(guestbookId));
	 * 
	 * } catch (Exception e) { SessionErrors.add(request,
	 * e.getClass().getName());
	 * 
	 * PortalUtil.copyRequestParameters(request, response);
	 * 
	 * response.setRenderParameter("mvcPath", "/html/guestbook/edit_entry.jsp");
	 * }
	 * 
	 * }
	 */

	public void addGuestbook(ActionRequest request, ActionResponse response) throws PortalException, SystemException {

		// Obtencion del ServiceContext
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Guestbook.class.getName(), request);

		// Recogida de pramtros de la request
		String name = ParamUtil.getString(request, "name");

		try {
			// Invocacion del servicio de Service Builder
			GuestbookLocalServiceUtil.addGuestbook(serviceContext.getUserId(), name, serviceContext);

			// Objeto queontrola los mensajes mostrados al usuario
			SessionMessages.add(request, "guestbookAdded");

		} catch (Exception e) {
			// En caso de error se incluyen las excepciones
			SessionErrors.add(request, e.getClass().getName());

			// Redireccion a la pagina de partida para solventar los errores,
			// que serán en principio de validacion
			response.setRenderParameter("mvcPath", "/html/guestbook/edit_guestbook.jsp");
		}

	}

	public void deleteEntry(ActionRequest request, ActionResponse response) {

		long entryId = ParamUtil.getLong(request, "entryId");
		long guestbookId = ParamUtil.getLong(request, "guestbookId");

		try {

			ServiceContext serviceContext = ServiceContextFactory.getInstance(Entry.class.getName(), request);

			response.setRenderParameter("guestbookId", Long.toString(guestbookId));

			EntryLocalServiceUtil.deleteEntry(entryId, serviceContext);

		} catch (Exception e) {

			SessionErrors.add(request, e.getClass().getName());
		}
	}
}
