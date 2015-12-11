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
 * @author ayarochkin
 */
public class sqlDelete {

    sqlConnection con = new sqlConnection();
    public sqlDelete(){
        
    }
    
    public String sqlDeleteRecord (String className, String recordId)
    {
        try {
            Statement stmt =  (Statement) con.obtainConnection().createStatement();
            String update = "delete from "+className+" where id='"+recordId+"'";
            stmt.executeUpdate(update);
        }
        catch(SQLException e)
        {
            throw new IllegalStateException("Connot delete from table!: "+e);
        }
    return "1";
    }

    
}
