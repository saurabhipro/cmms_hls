package com.iprosonic.cmms.pjcommons.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class SuccessAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String message = (String) request.getAttribute("message");
		request.setAttribute("message", message);
		ValueStack stack = ActionContext.getContext().getValueStack();
		Map<String, Object> context = new HashMap<String, Object>();
		context.put("message", message);
		stack.push(context);
		return SUCCESS;
	}
}
