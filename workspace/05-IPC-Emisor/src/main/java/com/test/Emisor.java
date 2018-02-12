package com.test;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class Emisor
 */
public class Emisor extends GenericPortlet {

    public void init() {
        viewTemplate = getInitParameter("view-template");
    }

    public void doView(
            RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

    	_log.info("Se procesa la view de Emisor");
    	
        //2-Public Render Parameter
        String parameter = renderRequest.getParameter("id1");
        _log.info("Public Render Parameter leido desde el Portlet emisor: " + parameter);
        
        include(viewTemplate, renderRequest, renderResponse);
    }

    @Override
    public void processAction(ActionRequest request, ActionResponse response)
    		throws PortletException, IOException {
    
    	_log.info("Se procesa la accion");
    	
    	//1-PortletSession
    	PortletSession session = request.getPortletSession();
        session.setAttribute("sessionValue", "dato compartido desde el Portlet Emisor" ,PortletSession.APPLICATION_SCOPE);
        
        //2-Public Render Parameter
    	response.setRenderParameter("id1", "parametro que se envia desde el emisor");
    	    	
    	//3-Eventos
    	QName qName = new QName("http://liferay.com", "empinfo", "x");
    	response.setEvent(qName, "Dato a enviar");
    	
    }
    
    protected void include(
            String path, RenderRequest renderRequest,
            RenderResponse renderResponse)
        throws IOException, PortletException {

        PortletRequestDispatcher portletRequestDispatcher =
            getPortletContext().getRequestDispatcher(path);

        if (portletRequestDispatcher == null) {
            _log.error(path + " is not a valid include");
        }
        else {
            portletRequestDispatcher.include(renderRequest, renderResponse);
        }
    }
 
    protected String viewTemplate;

    private static Log _log = LogFactoryUtil.getLog(Emisor.class);

}
