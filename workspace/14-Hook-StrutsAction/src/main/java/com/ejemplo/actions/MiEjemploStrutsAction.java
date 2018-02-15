package com.ejemplo.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.ParamUtil;

public class MiEjemploStrutsAction extends BaseStrutsAction {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		String name = ParamUtil.get(request, "name", "World");
		
		System.out.println("Parametro recibido: " + name);

        request.setAttribute("name", name);

        return "/portal/miejemplo.jsp";
	}
}
