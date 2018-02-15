import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;

public class MyCustomLogin extends BaseStrutsPortletAction {
	
	@Override
	public String render(StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse) throws Exception {

		System.out.println("En el interceptor del portlet");
		
		return originalStrutsPortletAction.render(originalStrutsPortletAction, portletConfig, renderRequest,
				renderResponse);
	}
}
