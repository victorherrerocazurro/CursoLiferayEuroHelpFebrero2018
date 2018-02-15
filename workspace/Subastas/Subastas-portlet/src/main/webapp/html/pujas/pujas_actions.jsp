<%@page import="com.example.plugins.model.Subasta"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.example.plugins.service.SubastaLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

	Subasta subasta = (Subasta) row.getObject();
%>

<liferay-ui:icon-menu>

		<!-- URL para acceder a la accion de edicion -->
		<portlet:renderURL var="pujarURL">
			<portlet:param name="subastaId" value="<%=String.valueOf(subasta.getSubastaId())%>" />
			<portlet:param name="mvcPath" value="/html/pujas/alta_puja.jsp" />
		</portlet:renderURL>

		<liferay-ui:icon image="edit" message="Pujar" url="<%=pujarURL.toString()%>" />

</liferay-ui:icon-menu>