<%@page import="com.example.plugins.service.SubastaLocalServiceUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<portlet:defineObjects />

<liferay-ui:search-container
	total="<%=SubastaLocalServiceUtil.getSubastasCount()%>">
	<liferay-ui:search-container-results
		results="<%=SubastaLocalServiceUtil.findSubastasActivasHoy(searchContainer.getStart(), searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.example.plugins.model.Subasta" modelVar="subasta">

		<liferay-ui:search-container-column-text property="nombreProducto" />

		<liferay-ui:search-container-column-text property="descripcion" />

		<liferay-ui:search-container-column-jsp
			path="/html/pujas/pujas_actions.jsp" align="right" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
