<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<portlet:defineObjects />

This is the <b>New</b> portlet in View mode.

<portlet:actionURL name="saludar" var="urlAction"></portlet:actionURL>

<a href="${urlAction}">Saludar</a>

${requestScope.saludo}


<%-- <fmt:message bundle="<%=portletConfig.getResourceBundle(request.getLocale())--%>"	key="saludo"> --%>
<%-- 	<fmt:param value="Antonio"></fmt:param> --%>
<%-- </fmt:message> --%>

<liferay-ui:message key="titulo" />

<%Object[] argumentos = new Object[]{"Juan"}; %>

<liferay-ui:message key="saludo" arguments="<%=argumentos%>" />

<liferay-ui:error key="MiErrorEnProperties"/>

<liferay-ui:error key="MiError"/>