<%@page import="com.ejemplo.Saludador"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="<%=Saludador.ACCION_SALUDAR%>" 
					portletMode="VIEW" 
					var="saludarURL"/>

<form action="<%=saludarURL%>" method="post" >
	<label>Nombre:</label><input type="text" name="<%=Saludador.PARAM_NOMBRE%>"/>
	<input type="submit" value="Saludar">
</form>