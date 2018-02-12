<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL name="accion" portletMode="VIEW" var="actionUrl"></portlet:actionURL>

<form action="${actionUrl}" method="post">
	<input type="submit" value="Enviar">
</form>

This is the <b>Emisor</b> portlet in View mode.

<button onclick="lanzarEvento()">Lanzar Evento</button>
