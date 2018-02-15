package com.example.plugins.portlets;

import java.io.IOException;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.example.plugins.model.Puja;
import com.example.plugins.service.PujaLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class PujasPortlet
 */
public class PujasPortlet extends MVCPortlet {

	public void pujar(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, SystemException, PortalException {

		// Obtencion del ServiceContext
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Puja.class.getName(), actionRequest);

		// Obtencion de Usuario
		User user = UserLocalServiceUtil.fetchUser(serviceContext.getUserId());

		Date now = new Date();

		// Recogida de pramtros de la request
		Long idSubasta = ParamUtil.getLong(actionRequest, "idSubasta");
		Double valorPuja = ParamUtil.getDouble(actionRequest, "valorPuja");

		long pujaId = CounterLocalServiceUtil.increment();

		// Creación del objeto con la PK, pero todavia no persistente, es una
		// factoria
		Puja puja = PujaLocalServiceUtil.createPuja(pujaId);

		puja.setUuid(serviceContext.getUuid());
		puja.setUserId(user.getUserId());
		puja.setGroupId(serviceContext.getScopeGroupId());
		puja.setCompanyId(user.getCompanyId());
		puja.setUserName(user.getFullName());
		puja.setCreateDate(serviceContext.getCreateDate(now));
		puja.setModifiedDate(serviceContext.getModifiedDate(now));
		puja.setIdSubasta(idSubasta);
		puja.setValorPuja(valorPuja);

		// Actualiza la entidad en la BD
		PujaLocalServiceUtil.pujar(puja);

	}

}
