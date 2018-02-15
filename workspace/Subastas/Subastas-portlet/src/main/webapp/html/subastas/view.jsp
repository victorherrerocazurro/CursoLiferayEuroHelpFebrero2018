<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL name="addSubasta" var="addSubastaURL"></portlet:actionURL>

<aui:form action="<%= addSubastaURL %>" name="<portlet:namespace />fm">

        <aui:fieldset>

            <aui:input name="nombreProducto" />
            <aui:input name="descripcion" />
            <aui:input name="precioMinimo" />
            <aui:input name="fechaFin" />

        </aui:fieldset>

        <aui:button-row>

            <aui:button type="submit"></aui:button>

        </aui:button-row>
</aui:form>
