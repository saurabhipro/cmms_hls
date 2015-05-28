<%@page import="com.iprosonic.cmms.pjcommons.valuelist.AssetCdStrAction"%>
<%@page import="com.iprosonic.cmms.pjcommons.valuelist.AssetSrNoStrAction"%>
<%@page import="com.iprosonic.cmms.pjcommons.valuelist.ExplosivePart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>

 <% 
	try{      
		 String s[]=null;
			List<String> li=	AssetSrNoStrAction.getSerialNoList();
			String[] str = new String[li.size()];
			Iterator<String> it = li.iterator();
			
			int i = 0;
			while(it.hasNext())
			{
				String p = (String)it.next();	
				str[i] = p;
				i++;
			}
			
			//jQuery related start		
				String query = (String)request.getParameter("q");
			
			
				int cnt=1;
				for(int j=0;j<str.length;j++)
				{
					if(str[j].toUpperCase().startsWith(query.toUpperCase()))
					{
						out.print(str[j]+"\n");
						if(cnt>=5)
							break;
						cnt++;
					}
				}
			//jQuery related end	
		
			

		    } 
		catch(Exception e){ 
 			e.printStackTrace(); 
 		}


 %>