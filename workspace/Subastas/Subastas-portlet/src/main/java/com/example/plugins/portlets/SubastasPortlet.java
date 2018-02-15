package com.example.plugins.portlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.example.plugins.model.Subasta;
import com.example.plugins.service.SubastaLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class SubastasPortlet
 */
public class SubastasPortlet extends MVCPortlet {

	public void addSubasta(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException, PortalException, SystemException {
		
		// Obtencion del ServiceContext
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Subasta.class.getName(), actionRequest);

		//Obtencion de Usuario
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());
		
		Date now = new Date();
		
		// Recogida de pramtros de la request
		String nombreProducto = ParamUtil.getString(actionRequest, "nombreProducto");
		String descripcion = ParamUtil.getString(actionRequest, "descripcion");
		Double precioMinimo = ParamUtil.getDouble(actionRequest, "precioMinimo");
		Date fechaFin = ParamUtil.getDate(actionRequest, "fechaFin", new SimpleDateFormat("dd/MM/yyyy"));

		long subastaId = CounterLocalServiceUtil.increment();

		//Creación del objeto con la PK, pero todavia no persistente, es una factoria
		Subasta subasta = SubastaLocalServiceUtil.createSubasta(subastaId);

		subasta.setUuid(serviceContext.getUuid());
		subasta.setUserId(user.getUserId());
		subasta.setGroupId(serviceContext.getScopeGroupId());
		subasta.setCompanyId(user.getCompanyId());
		subasta.setUserName(user.getFullName());
		subasta.setCreateDate(serviceContext.getCreateDate(now));
		subasta.setModifiedDate(serviceContext.getModifiedDate(now));
		subasta.setNombreProducto(nombreProducto);
		subasta.setDescripcion(descripcion);
		subasta.setPrecioMinimo(precioMinimo);
		subasta.setFechaFin(fechaFin);

		//Actualiza la entidad en la BD
		SubastaLocalServiceUtil.addSubasta(subasta);
		
		
	}

}
