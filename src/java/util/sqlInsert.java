/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alex
 */
public class sqlInsert {

sqlConnection con = new sqlConnection();
    
    public sqlInsert(){

        }

    public String sqlAddRecord (String companyId, String siteId, String className, String ip, String name, String model, String login, String password, String url)
    {
        try {
            Statement stmt =  (Statement) con.obtainConnection().createStatement();
            String update = "INSERT into "+className+" (companyId, siteId, ip, name, model, login, password, url) values ('"+companyId+"', '"+siteId+"', '"+ip+"', '"+name+"', '"+model+"', '"+login+"', '"+password+"','"+url+"')";
            stmt.executeUpdate(update);
        }
        catch(SQLException e)
        {
            throw new IllegalStateException("Connot insert into table!: "+e);
        }
    return "1";
    }

}
    

