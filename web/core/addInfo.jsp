<%@include file='authcheck.jsp' %>
<%-- 
    Document   : updateInfo
    Created on : Aug 24, 2015, 9:15:26 PM
    Author     : ayarochkin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="../style.css" type="text/css"/>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hello, <%=user %>!</title>
    </head>
    <body>
               <div id="mainwrapper">
   <!-- Menu start -->     
        <%@include  file='menu.jsp' %>
   <!-- menu end -->

<div id="content-wrapper">
 <% int siteId = Integer.parseInt(request.getParameter("siteId").toString());
    String className = request.getParameter("class");
 //   int recordId = Integer.parseInt(request.getParameter("recordId").toString());
 %>
    <!-- Table start -->
    <div style="margin: 10px;"><font color="#0095d3" style="font-weight: bold;">Modifying: <%=siteId%> <%=className%></font></div>
     <%
 //Main select and assign all main variables 
        sqlSelect myMainSelect = new sqlSelect();
        int[] sitesId = myMainSelect.obtainSitesID(companyId);
        String [] sitesName = myMainSelect.obtainSitesName(companyId);
        int [] userAccess = myMainSelect.obtainUserAccess(user);
        String tableField[] = {"ip", "name", "model", "login", "password", "url"};
//siteName loop starts

//classNames loop starts vpn,firewall,network,windows etc.


            //check if any records in firewall tables for companyId and siteId is present, if yes display it

            //Get array[][] from firewall table
            //String[] classRecord = myMainSelect.obtainClassRecord(companyId, siteId, className,recordId);    

    %>

<!-- Class Loop -->
<div class="mainHeadTop"><%=siteId%>: <%=className%></div>
    
    <form name="updateInfo" method="post" action="../addInfo">
<div class="displayTableMain">
        <div class="displayRowMain">
            <div class="displayCellMain"><input class="mainHeadSub" readonly="" value="IP"></div><div class="displayCellMain"><input class="mainHeadSub" readonly="" value="Name"></div><div class="displayCellMain"><input class="mainHeadSub" readonly="" value="Model/OS"></div><div class="displayCellMain"><input class="mainHeadSub" readonly="" value="Login"></div><div class="displayCellMain"><input class="mainHeadSub" readonly="" value="Password"></div><div class="displayCellMain"><input class="mainHeadSub" readonly="" value="URL"></div>
        </div>
        

        <%  
            
            
            
            %><div class="displayRowMain"><%
                for (int j=0; j< tableField.length; j++)
                {
                    %><div class="displayCellMain"><input name="<%=tableField[j]%>" class="input" value=""></div><%
                }
                %></div><%
            
         %>
 
        <input type="hidden" name="siteId" value="<%=siteId%>">
        <input type="hidden" name="className" value="<%=className%>">
</div>
 <div style="padding-left: 20px;"><input type="submit" value="Add   " class="submitButton"></div>
    </form>

</div>   
   
                   

               </div>
    </body>
</html>
