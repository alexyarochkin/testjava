<%@page import="javax.servlet.http.Cookie" %>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="util.sqlSelect" %>
<% HttpSession sessionJSP = request.getSession(false);
    if (sessionJSP.getAttribute("user") == null )
    { 
        response.sendRedirect("../");
        
    }
    String user = null;
    String userUuid = null;
    int companyId;
    companyId = 1;
    String userModify = "none";
    String companyModify = "none";
         
    if (sessionJSP.getAttribute("user") != null)
    {
    user = sessionJSP.getAttribute("user").toString();
    userUuid = sessionJSP.getAttribute("userUuid").toString();
    companyId = Integer.parseInt(sessionJSP.getAttribute("companyId").toString());
            if (sessionJSP.getAttribute("userModify") != null)
                {
                    userModify = sessionJSP.getAttribute("userModify").toString();
                }
    
           if (sessionJSP.getAttribute("companyModify") != null)
                {
                   companyModify = sessionJSP.getAttribute("companyModify").toString();
                }
 
    
    }
    else 
    {
        user  = "none";
        userUuid = "none";
        
    }
    
    
    

//    String classNames[] = {"vpn","firewall", "network", "linux", "windows", "vmware", "ups", "cloud", "printers", "applications", "serviceAccount"};
    sqlSelect  mySelect = new sqlSelect();
    String [] classNames = mySelect.obtainClassesList();
    String classAccess[] = {"no","read", "write"};

%>
