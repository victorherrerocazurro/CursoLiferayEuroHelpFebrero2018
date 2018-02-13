<%@include file="/html/init.jsp"%>

<%
    long guestbookId = Long.valueOf((Long) renderRequest.getAttribute("guestbookId"));

	List<Guestbook> guestbooks = GuestbookLocalServiceUtil.getGuestbooks(scopeGroupId);
	
	
	GuestbookLocalServiceUtil.buscarPorNombre("pepe", 1, 1);
%>
<aui:nav cssClass="nav-tabs">

    <%
	   		for(Guestbook curGuestbook : guestbooks){

                String cssClass = StringPool.BLANK;

                if (curGuestbook.getGuestbookId() == guestbookId) {
                    cssClass = "active";
                }
                
                if (GuestbookPermission.contains(
						permissionChecker, curGuestbook.getGuestbookId(), "VIEW")) {
    %>

    <portlet:renderURL var="viewPageURL">
        <portlet:param name="mvcPath" value="/html/guestbook/view.jsp" />
        <portlet:param name="guestbookId"
            value="<%=String.valueOf(curGuestbook.getGuestbookId())%>" />
    </portlet:renderURL>

    <aui:nav-item cssClass="<%=cssClass%>" href="<%=viewPageURL%>"
        label="<%=HtmlUtil.escape(curGuestbook.getName())%>" />

    <%
        		}
			}
    %>

</aui:nav>


<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="populatePanel" persistState="<%= true %>" title="populate">
	<liferay-ui:search-container
	        total="<%=EntryLocalServiceUtil.getEntries(scopeGroupId,
	                        guestbookId).size()%>"
	>
	    <liferay-ui:search-container-results
	        results="<%=EntryLocalServiceUtil.getEntries(scopeGroupId,
	                        guestbookId, searchContainer.getStart(),
	                        searchContainer.getEnd())%>" />
	
	    <liferay-ui:search-container-row
	        className="com.liferay.docs.guestbook.model.Entry" modelVar="entry">
	
	        <liferay-ui:search-container-column-text property="message" />
	
	        <liferay-ui:search-container-column-text property="name" />
	        
	        <liferay-ui:search-container-column-jsp path="/html/guestbook/guestbook_actions.jsp" align="right" />
	
	    </liferay-ui:search-container-row>
	
	    <liferay-ui:search-iterator />
	</liferay-ui:search-container>
</liferay-ui:panel>
<aui:button-row cssClass="guestbook-buttons">

	<c:if test='<%= GuestbookModelPermission.contains(permissionChecker, scopeGroupId, "ADD_GUESTBOOK") %>'>
	    <portlet:renderURL var="addGuestbookURL">
	        <portlet:param name="mvcPath" value="/html/guestbook/edit_guestbook.jsp" />
	    </portlet:renderURL>
		
		<aui:button onClick="<%=addGuestbookURL.toString()%>" value="Add Guestbook" />
    </c:if>
	
	<c:if test='<%= GuestbookPermission.contains(permissionChecker, guestbookId, "ADD_ENTRY") %>'>
	    <portlet:renderURL var="addEntryURL">
	        <portlet:param name="mvcPath" value="/html/guestbook/edit_entry.jsp" />
	        <portlet:param name="guestbookId" value="<%=String.valueOf(guestbookId)%>" />
	    </portlet:renderURL>
	
	    <aui:button onClick="<%=addEntryURL.toString()%>" value="Add Entry"></aui:button>
	    <aui:button id="useNameButton" value="JavaScript"></aui:button>
	</c:if>
</aui:button-row>