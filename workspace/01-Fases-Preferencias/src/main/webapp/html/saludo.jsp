<%@page import="com.ejemplo.Saludador"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:renderURL portletMode="VIEW" var="initViewURL"/>

<%=request.getAttribute(Saludador.PARAM_SALUDO) %>

${requestScope.saludo}

<a href="<%=initViewURL %>">volver</a>
