package com.iprosonic.cmms.pjcommons.utility;

import java.io.PrintStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetSessionTime extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(ServletActionContext.HTTP_RESPONSE);
		
		PrintWriter pw=response.getWriter();
		
		
		HttpSession session = request.getSession(false);

		// session will almost *never* be null. Check for a valid user object.
		Object obj = session.getAttribute("loginid");
		System.out.println("Session Time Left :"+(10000000L-(session.getLastAccessedTime()-session.getCreationTime()))/1000+" sec.");
		StringBuffer sb=new StringBuffer();
		sb.append("Session Time Left :"+(10000000L-(session.getLastAccessedTime()-session.getCreationTime()))/1000+" sec.");
		
		pw.write(sb.toString());
		return null;
	}
}
