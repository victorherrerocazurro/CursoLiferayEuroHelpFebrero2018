<%@page import="com.ejemplo.Saludador"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="<%=Saludador.ACCION_DEFINIR_PREFERENCIAS%>" 
					portletMode="VIEW" 
					var="definirPreferenciasURL"/>

<form action="<%=definirPreferenciasURL%>" method="post">
	<label>Prefijo:</label><input type="text" name="<%=Saludador.PARAM_PREFIJO%>" value="<%=portletPreferences.getValue(Saludador.PARAM_PREFIJO, "")%>"/>
	<label>Sufijo:</label><input type="text" name="<%=Saludador.PARAM_SUFIJO%>" value="<%=portletPreferences.getValue(Saludador.PARAM_SUFIJO, "")%>"/>
	<input type="submit" value="Enviar">
</form>