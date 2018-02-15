AUI().ready('aui-alert','aui-io-request', function(Y) {
	new Y.Alert({
		closeable : true,
		render : true,
		srcNode : '#myAlert'
	});
});

Liferay.Portlet.ready(

/*
 * This function gets loaded after each and every portlet on the page.
 * 
 * portletId: the current portlet's id node: the Alloy Node object of the
 * current portlet
 */

function(portletId, node) {
});

Liferay.on('allPortletsReady',

/*
 * This function gets loaded when everything, including the portlets, is on the
 * page.
 */

function() {
});