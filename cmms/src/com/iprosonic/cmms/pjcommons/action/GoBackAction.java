package com.iprosonic.cmms.pjcommons.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoBackAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	public String execute() {

		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);

		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);

		String oldURL = request.getParameter("oldURL");
		
		try {
			response.sendRedirect(oldURL);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return NONE;

	}

}
