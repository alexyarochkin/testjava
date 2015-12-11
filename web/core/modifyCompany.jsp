<%@include file='authcheck.jsp' %>
<%-- 
    Document   : modifyCompany
    Created on : Aug 30, 2015, 4:03:10 PM
    Author     : ayarochkin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="style.css" type="text/css"/>
        <link rel="stylesheet" href="../style.css" type="text/css"/>
        <title>Hello, <%=user %>!</title>
    </head>
    <body>
 <div id="mainwrapper">
   <!-- Menu start -->     
        <%@include  file='menu.jsp' %>
   <!-- menu end -->
<div id="content-wrapper">
 
    <!-- Table start -->
    <div style="margin: 10px;"><font color="#0095d3" style="font-weight: bold;">Modifying: <%=companyModify%></font></div>

</div>
<!-- Content -->
 
 </div>
 </body>
</html>
