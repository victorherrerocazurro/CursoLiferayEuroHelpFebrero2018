package com.ejemplo.struts.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

//Este Action se ejecuta cuando se pone en el navegador
//			http://localhost:8080/c/portal/sample

public class SampleAction extends BaseStrutsAction {

	private Integer start;
	private Integer length;

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		start = Integer.parseInt(request.getParameter("start"));
		length = Integer.parseInt(request.getParameter("length"));
		
		try {
			System.out.println("====serveResource========");
			System.out.println("start = " + start + "; length= " + length);
			JSONObject jsonUser = null;
			JSONArray usersJsonArray = JSONFactoryUtil.createJSONArray();

			List<User> userList = UserLocalServiceUtil.getUsers(start + 1,
					start + length);

			// Transformacion de los objetos de tipo User a objetos de tipo JSON

			for (User userObj : userList) {
				jsonUser = JSONFactoryUtil.createJSONObject();
				jsonUser.put("firstName", userObj.getFirstName());
				jsonUser.put("lastName", userObj.getLastName());
				jsonUser.put("email", userObj.getEmailAddress());
				jsonUser.put("screeName", userObj.getScreenName());
				usersJsonArray.put(jsonUser);
			}
			PrintWriter out = response.getWriter();

			JSONObject jsonResult = JSONFactoryUtil.createJSONObject();

			jsonResult.put("data", usersJsonArray);

			jsonResult.put("draw", (start + length) / length);
			jsonResult
					.put("recordsTotal", UserLocalServiceUtil.getUsersCount());
			jsonResult.put("recordsFiltered",
					UserLocalServiceUtil.getUsersCount());

			System.out.println(jsonResult.toString());

			out.print(jsonResult.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
