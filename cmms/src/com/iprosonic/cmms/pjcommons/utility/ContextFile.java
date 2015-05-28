package com.iprosonic.cmms.pjcommons.utility;



import javax.servlet.ServletContext;
import org.apache.struts2.ServletActionContext;
public class ContextFile {


	public static String getContextFile(String path) {
		String filePath = null;

		try {
			ServletContext context = ServletActionContext.getServletContext();
			filePath = context.getRealPath(path);
		} catch (Exception ex) {
			StackTraceElement[] ste = ex.getStackTrace();
			for (StackTraceElement info : ste) {
				
						

			}

		}

		return filePath;
	}

}
