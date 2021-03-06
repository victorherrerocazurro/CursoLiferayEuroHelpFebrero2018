<%@include file="/html/init.jsp"%>

<%
	Entry entry = (Entry) renderRequest.getAttribute("gb_entry");
%>

<portlet:renderURL var="viewURL">
	<portlet:param name="mvcPath" value="/html/guestbook/view.jsp"></portlet:param>
</portlet:renderURL>

<aui:form action="<%=addEntryURL%>" name="<portlet:namespace />fm">
	<aui:model-context bean="<%=entry%>" model="<%=Entry.class%>" />
	<aui:fieldset>
		<aui:layout>
			<aui:column >
				<aui:input name="name" />
				<aui:input name="email" />
			</aui:column>
			<aui:column>
				<aui:input name="message" />
				<aui:input name='guestbookId' type='hidden'
					value='<%=ParamUtil.getString(renderRequest, "guestbookId")%>' />
				<aui:input name='entryId' type='hidden' />
			</aui:column>
		</aui:layout>
	</aui:fieldset>
	<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="entryAssetLinksPanel" persistState="<%= true %>" title="contenidos relacionados">
	    <aui:fieldset>
	        <liferay-ui:input-asset-links
	            className="<%= Entry.class.getName() %>"
	            classPK="<%= entryId %>"
	        />
	    </aui:fieldset>
	</liferay-ui:panel>
	<aui:button-row>
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>"></aui:button>
	</aui:button-row>
</aui:form>

