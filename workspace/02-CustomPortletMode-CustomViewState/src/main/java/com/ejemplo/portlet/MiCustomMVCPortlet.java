package com.ejemplo.portlet;
import java.io.IOException;

import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;


public class MiCustomMVCPortlet extends GenericPortlet {
		
	@RenderMode(name="VIEW")
	public void doCustomView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		System.out.println("En render view");
		getPortletContext().getRequestDispatcher("/MiCustomPortlet/view.jsp").include(request, response);
	}
	
	@RenderMode(name="CUSTOM")
	public void doCustomRenderMode(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		
		System.out.println("En render custom");
		getPortletContext().getRequestDispatcher("/MiCustomPortlet/customRenderMode.jsp").include(renderRequest, renderResponse);
		
	}
}
