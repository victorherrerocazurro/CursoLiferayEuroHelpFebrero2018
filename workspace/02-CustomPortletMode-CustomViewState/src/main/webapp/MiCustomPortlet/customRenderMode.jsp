<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<portlet:defineObjects />

Custom Render View

<portlet:renderURL portletMode="VIEW" var="viewRenderModeUrl"></portlet:renderURL>

<a href="${viewRenderModeUrl}">View Mode</a>