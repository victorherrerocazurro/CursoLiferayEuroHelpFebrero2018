package com.test;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class NewPortlet
 */
public class NewPortlet extends MVCPortlet {
 
	public void saludar(ActionRequest request, ActionResponse response) throws Exception {
		
		ResourceBundle resourceBundle = getResourceBundle(request.getLocale());
		
		String mensaje = MessageFormat.format(resourceBundle.getString("saludo"), "Victor");
		
		System.out.println(mensaje);
		
		request.setAttribute("saludo", mensaje);
		
		SessionErrors.add(request, "MiError", "SE ha producido un error en el Action");
		
		SessionErrors.add(request, "MiErrorEnProperties");
		
	}

}
