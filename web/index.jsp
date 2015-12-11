<%@page import="javax.servlet.http.Cookie" %>
<%@page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <link rel='stylesheet' href='style.css' type='text/css'/>

        <title>Talachabee!</title>
        <meta charset='UTF-8'>
        <meta name='viewport' content='width=device-width, initial-scale=1.0'>

    </head>
    <body class="body-login">
        
  <div id='wrapper'>

	<form name='login-form' class='login-form' action='validate' method='post'>
	
		<div class='header'>
		<h1>Talachabee</h1>
                <% 
                    HttpSession sessionJSP = request.getSession(false);
                    if (sessionJSP.getAttribute("attempted") != null){
                    String attempted = sessionJSP.getAttribute("attempted").toString();
                    if (attempted.equals("retry"))
                    { %>
                    <span><font style="color: red">Incorrect password.</font></span>   
                    <%
                    }
                    }
                    else {
                %>
		<span></span>
                <% } %>
		</div>
	
		<div class='content'>
		<input name='user' type='text' class='input username' placeholder='Username' />
		<div class='user-icon'></div>
		<input name='pass' type='password' class='input password' placeholder='Password' />
		<div class='pass-icon'></div>		
		</div>

		<div class='footer'>
		<input type='submit' name='submit' value='Login' class='button' />
                <input type='submit' name='submit' value='Register' class='register' />
                </div>
                <div class='forget-password'>
                <input type='submit' name='submit' value='Forget Password' class='fpassword'>
                </div>
	
	</form>

</div>
<div class='gradient'></div>    
</body>
</html>
