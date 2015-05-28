package com.iprosonic.cmms.pjcommons.utility;

import java.util.Map;
import org.apache.struts2.StrutsStatics;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class SessionCheckInterceptor extends AbstractInterceptor implements
		StrutsStatics {
	private static final long serialVersionUID = 1L;

	public void init() {
	}

	public void destroy() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {

		Map<String, Object> session = invocation.getInvocationContext()
				.getSession();

		ActionContext context = invocation.getInvocationContext();
		session = context.getSession();
		Object obj = session.get("loginid");
		
		if (obj == null || session.isEmpty())
			return "sessionExpired";
		else
			return invocation.invoke();
	}
}
