<%@page import="com.example.plugins.service.PujaLocalServiceUtil"%>
<%@page import="com.example.plugins.service.SubastaLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL name="pujar" var="pujarURL"></portlet:actionURL>

<%
long subastaId = ParamUtil.getLong(renderRequest, "subastaId");
long idPujaMaxima = SubastaLocalServiceUtil.fetchSubasta(subastaId).getPujaMaxima();
double pujaMaxima = PujaLocalServiceUtil.getPuja(idPujaMaxima).getValorPuja();
%>

<aui:form action="<%= pujarURL %>" name="<portlet:namespace />fm">

        <aui:fieldset>
			<aui:input name="pujaMaxima" 
					value='<%=pujaMaxima%>' />
            <aui:input name="valorPuja" />
            <aui:input name="idSubasta" type='hidden'
					value='<%=subastaId%>' />

        </aui:fieldset>

        <aui:button-row>

            <aui:button type="submit"></aui:button>

        </aui:button-row>
</aui:form>