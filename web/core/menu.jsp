<%@page import='util.sqlSelect' %>

<%-- 
    Document   : menu.jsp
    Created on : Jun 26, 2015, 7:44:09 PM
    Author     : alex
--%>

<!-- Menu start -->

<div id="menu"  >
<ul>

    <li> <form action="../changeCompany" method="post"> 
        <select name="companyId" class="input">
        <% 
            sqlSelect mySelectCompanies = new sqlSelect();
            String myCompanies[] = mySelectCompanies.obtainCompanies();
            int myCompaniesId[] = mySelectCompanies.obtainCompaniesId();
            for (int i = 0; i < myCompanies.length; i++)
            {
                %>
                <option value="<%=myCompaniesId[i]%>" <% if (companyId == myCompaniesId[i]){ %> selected <% }%> ><%=myCompanies[i]%> </option>
                
                <%
                
            }
        %>
        </select>
        <input type="submit" name="changeCompany" value="change" class="submitButton">
        </form>
    </li>
    <li class="inside"><a href="main.jsp"><h4 class="menustyle"><span>Main</span></h4></a>
    </li>


    <% 
      
            
            if (user.equals("ayarochkin") || user.equals("usattar") || user.equals("gstiavetti"))
    {
        %>
            <li class="inside"><a href="settings.jsp"><h4 class="menustyle"><span>Settings</span></h4></a>

            </li>

        <%
        
    }
    %>

    <% 
      
            
            if (user.equals("ayarochkin") || user.equals("usattar") || user.equals("gstiavetti"))
    {
        %>
            <li class="inside"><a href="companies.jsp"><h4 class="menustyle"><span>Companies</span></h4></a>

            </li>

        <%
        
    }
    %>

    <li class="inside"><a href="../logout"><h4 class="menustyle"><span>Logout</span></h4></a>
    </li>


</ul>
</div>

<!--MenuEND-->
