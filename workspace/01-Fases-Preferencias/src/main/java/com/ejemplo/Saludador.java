package com.ejemplo;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderMode;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Portlet implementation class Saludador
 */
public class Saludador extends GenericPortlet {

	//private Logger logger = Logger.getLogger(Saludador.class);
	private static Log logger = LogFactoryUtil.getLog(Saludador.class);
	
	private String initView;
	private String saludoView;
	private String editView;
	
	public static final String ACCION_SALUDAR = "saludarAction";
	public static final String ACCION_DEFINIR_PREFERENCIAS = "definirPreferenciasAction";
	
	public static final String PARAM_SALUDO = "saludo";
	public static final String PARAM_PREFIJO = "prefijo";
	public static final String PARAM_SUFIJO = "sufijo";
	public static final String PARAM_NOMBRE = "nombre";
	
	@Override
	public void init() throws PortletException {
		super.init();
		initView = getInitParameter("init-view-template");
		saludoView = getInitParameter("saludo-view-template");
		editView = getInitParameter("init-edit-template");
	}

	@RenderMode(name="VIEW")
	public void renderView(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		
		//Se recoge la accion como RenderParameter
		logger.info("Accion: " + request.getParameter(ActionRequest.ACTION_NAME));		
		
		String accion = request.getParameter(ActionRequest.ACTION_NAME);
		
		//Creacion de una url de accion
		PortletURL actionURL = response.createActionURL();
		actionURL.setParameter(ActionRequest.ACTION_NAME, ACCION_SALUDAR);
		
		//Creacion de una url de render
		PortletURL renderURL = response.createRenderURL();
		renderURL.setPortletMode(PortletMode.VIEW);
		
		if(ACCION_SALUDAR.equals(accion)){
			//Parametros  recogidos como RenderParam
			logger.info("Saludo: " + request.getParameter(PARAM_SALUDO));
			//Parametros recogidos de la Session (JSR168)
			logger.info("Saludo por session: " + request.getPortletSession().getAttribute(PARAM_SALUDO, PortletSession.PORTLET_SCOPE));
			logger.info("Saludo por session: " + request.getPortletSession().getAttribute(PARAM_SALUDO));
			//Parametros recogidos como atributos de la request (JSR286)
			logger.info("Saludo por atributo de request: " + request.getAttribute(PARAM_SALUDO));
			
			//No es necesario incluir en la request el atributo con el saludo que se obtuvo en la accion, ya que está
			//request.setAttribute(PARAM_SALUDO, request.getParameter(PARAM_SALUDO));
			include(request, response, saludoView);
		} else {
			
			PortletURL saludoURL = response.createActionURL();
			saludoURL.setParameter(ActionRequest.ACTION_NAME, ACCION_SALUDAR);
			
			request.setAttribute("urlSaludar", saludoURL);
			
			include(request, response, initView);
		}
	}
	
	@RenderMode(name="EDIT")
	public void renderEdit(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		include(request, response, editView);
	}
	
	private void include(RenderRequest request, RenderResponse response, String view)
			throws PortletException, IOException {
		getPortletContext().getRequestDispatcher(view).include(request, response);
	}
	
	@ProcessAction(name=ACCION_SALUDAR)
	public void saludar(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {
		
		//Se recogen los parametros enviados en el formulario
		logger.info("Nombre: " + request.getParameter(PARAM_NOMBRE));
		//Siempre se envia el parametro que define la accion a ejecutar
		logger.info("Accion: " + request.getParameter(ActionRequest.ACTION_NAME));
		
		
		PortletPreferences preferences = request.getPreferences();
		
		String prefijo = preferences.getValue(PARAM_PREFIJO, "");
		String sufijo = preferences.getValue(PARAM_SUFIJO, "");
		
		//Para poder coger los parametros por nombre, es necesario activar en liferay-portlet.xml
		//<portlet>
		//	<requires-namespaced-parameters>false</requires-namespaced-parameters>
		//</portlet>
		String saludo = prefijo + request.getParameter(PARAM_NOMBRE) + sufijo; 
		
		//Parametros enviados por RenderParam (Solo String)
		response.setRenderParameter(PARAM_SALUDO, saludo);
		response.setRenderParameter(ActionRequest.ACTION_NAME, request.getParameter(ActionRequest.ACTION_NAME));
		
		//Parametros enviados por Session (JSR168) (Objetos)
		request.getPortletSession().setAttribute(PARAM_SALUDO, saludo , PortletSession.PORTLET_SCOPE);
		
		//Parametros eniados por atributos de la request (JSR286) (Objetos)
		//Necesario activar esta funcionalidad en portlet.xml con la etiqueta
		
		//<container-runtime-option>
		//	<name>javax.portlet.actionScopedRequestAttributes</name>
		//	<value>true</value>
		//</container-runtime-option>
		
		request.setAttribute(PARAM_SALUDO, saludo);
	}
	
	@ProcessAction(name=ACCION_DEFINIR_PREFERENCIAS)
	public void definirPreferencias(ActionRequest request, ActionResponse response)
			throws PortletException, IOException {

		logger.info("Prefijo: " + request.getParameter(PARAM_PREFIJO));
		logger.info("Sufijo: " + request.getParameter(PARAM_SUFIJO));
		
		PortletPreferences preferences = request.getPreferences();
		
		preferences.setValue(PARAM_PREFIJO, request.getParameter(PARAM_PREFIJO));
		preferences.setValue(PARAM_SUFIJO, request.getParameter(PARAM_SUFIJO));
		
		try {
			preferences.store();
		} catch (ValidatorException e) {
			// En el caso de definir un PreferencesValidator, habria que capturar
			// el error para mostrar una vista adecuada al error, posiblemente la
			// vista sea la misma, ya que se trata de un formulario para captar
			//el valor de la preferencia, pero haya que incluir algun mensaje de error.
			e.printStackTrace();
		}
		
		//Permite definir que metodo de render se ejecutara. De esta forma se consigue permanecer en la vista de EDIT.
		//response.setPortletMode(PortletMode.EDIT);
		
	}
}
