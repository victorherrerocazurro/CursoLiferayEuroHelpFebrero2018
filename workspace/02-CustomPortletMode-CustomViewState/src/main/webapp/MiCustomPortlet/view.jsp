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

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:renderURL portletMode="CUSTOM" var="customRenderModeUrl"></portlet:renderURL>
<portlet:renderURL portletMode="EDIT" var="editRenderModeUrl"></portlet:renderURL>

<portlet:renderURL portletMode="ABOUT" var="aboutRenderModeUrl"></portlet:renderURL>
<portlet:renderURL portletMode="CONFIG" var="configRenderModeUrl"></portlet:renderURL>
<portlet:renderURL portletMode="PRINT" var="printRenderModeUrl"></portlet:renderURL>
<portlet:renderURL portletMode="PREVIEW" var="previewRenderModeUrl"></portlet:renderURL>
<portlet:renderURL portletMode="EDIT_DEFAULTS" var="editDefaultsRenderModeUrl"></portlet:renderURL>
<portlet:renderURL portletMode="EDIT_GUEST" var="editGuestRenderModeUrl"></portlet:renderURL>

<a href="${customRenderModeUrl}">Custom Mode</a>
<a href="${editRenderModeUrl}">EDIT Mode</a>

<a href="${aboutRenderModeUrl}">ABOUT Mode</a>
<a href="${configRenderModeUrl}">CONFIG Mode</a>
<a href="${printRenderModeUrl}">PRINT Mode</a>
<a href="${previewRenderModeUrl}">PREVIEW Mode</a>
<a href="${editDefaultsRenderModeUrl}">EDIT_DEFAULTS Mode</a>
<a href="${editGuestRenderModeUrl}">EDIT_GUEST Mode</a>

This is the <b>02-CustomPortletMode-CustomViewState</b>.