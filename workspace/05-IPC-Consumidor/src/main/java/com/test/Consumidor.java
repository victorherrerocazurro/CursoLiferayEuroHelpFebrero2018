package com.test;

import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class Consumidor
 */
public class Consumidor extends GenericPortlet {

	public void init() {
		viewTemplate = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		_log.info("Se procesa la view de Consumidor");

		// 1-PortletSession
		PortletSession ps = renderRequest.getPortletSession();
		String parametroSession = (String) ps.getAttribute("sessionValue",
				PortletSession.APPLICATION_SCOPE);

		ps.removeAttribute("sessionValue");

		_log.info("Parametro de Session: " + parametroSession);

		// 2-Public Render Parameter
		String parameter = renderRequest.getParameter("id1");
		_log.info("Parametro de Render: " + parameter);

		include(viewTemplate, renderRequest, renderResponse);
	}

	// 3-Eventos
	@ProcessEvent(qname = "{http://liferay.com}empinfo")
	public void handleProcessempinfoEvent(javax.portlet.EventRequest request,
			javax.portlet.EventResponse response)
			throws javax.portlet.PortletException, java.io.IOException {

		javax.portlet.Event event = request.getEvent();
		String value = (String) event.getValue();
		_log.info("value in process event>>>>>>>>>" + value);
	}

	protected void include(String path, RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(path);

		if (portletRequestDispatcher == null) {
			_log.error(path + " is not a valid include");
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
	}

	protected String viewTemplate;

	private static Log _log = LogFactoryUtil.getLog(Consumidor.class);

}
