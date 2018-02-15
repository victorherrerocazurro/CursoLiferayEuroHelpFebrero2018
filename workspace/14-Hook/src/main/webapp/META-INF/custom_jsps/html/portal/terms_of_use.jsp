<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portal/init.jsp" %>

<%
String currentURL = PortalUtil.getCurrentURL(request);

String referer = ParamUtil.getString(request, WebKeys.REFERER, currentURL);

if (referer.equals(themeDisplay.getPathMain() + "/portal/update_terms_of_use")) {
	referer = themeDisplay.getPathMain() + "?doAsUserId=" + themeDisplay.getDoAsUserId();
}
%>

<aui:form action='<%= themeDisplay.getPathMain() + "/portal/update_terms_of_use" %>' name="fm">
	<aui:input name="doAsUserId" type="hidden" value="<%= themeDisplay.getDoAsUserId() %>" />
	<aui:input name="<%= WebKeys.REFERER %>" type="hidden" value="<%= referer %>" />

	No hay terminos de uso que aceptar

	<c:if test="<%= !user.isAgreedToTermsOfUse() %>">
		<aui:button-row>
			<aui:button type="submit" value="i-agree" />

			<%
			String taglibOnClick = "alert('" + UnicodeLanguageUtil.get(pageContext, "you-must-agree-with-the-terms-of-use-to-continue") + "');";
			%>

			<aui:button onClick="<%= taglibOnClick %>" type="cancel" value="i-disagree" />
		</aui:button-row>
	</c:if>
</aui:form>