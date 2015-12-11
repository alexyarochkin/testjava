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
public class sqlUpdate {

    sqlConnection con = new sqlConnection();
     
    public sqlUpdate(){
        
        
       

    }
    public String sqlUpdateIsp(String id, String name,String portDown, String phone)
    {
        try {
            Statement stmt =  (Statement) con.obtainConnection().createStatement();
            String update = "UPDATE isp set name='"+name+"',portDown='"+portDown+"',phone='"+phone+"' where id='"+id+"'";
            stmt.executeUpdate(update);
        }
        catch(SQLException e)
        {
            throw new IllegalStateException("Connot insert into table!: "+e);
        }
    return "1";
    }
    
    public String sqlUpdateFirewall(String id, String name,String portDown1, String portDown2)
    {
        try {
            Statement stmt =  (Statement) con.obtainConnection().createStatement();
            String update = "UPDATE firewall set name='"+name+"',portDown1='"+portDown1+"',portDown2='"+portDown2+"' where id='"+id+"'";
            stmt.executeUpdate(update);
        }
        catch(SQLException e)
        {
            throw new IllegalStateException("Connot insert into table!: "+e);
        }
    return "1";
    }
    
    public String sqlUpdateUserAccess (int userAccess[], String userModify)
    {
        try {
            Statement stmt =  (Statement) con.obtainConnection().createStatement();
            String update = "UPDATE users SET vpn="+userAccess[0]+", firewall="+userAccess[1]+", network="+userAccess[2]+", linux="+userAccess[3]+", windows="+userAccess[4]+", vmware="+userAccess[5]+", ups="+userAccess[6]+", cloud="+userAccess[7]+", printers="+userAccess[8]+", applications="+userAccess[9]+", serviceAccount="+userAccess[10]+", storage="+userAccess[11]+" where user='"+userModify+"'";
            stmt.executeUpdate(update);
        }
        catch(SQLException e)
        {
            throw new IllegalStateException("Connot insert into table!: "+e);
        }
    return "1";
    }

    public String sqlUpdateRecord (String siteId, String className, String recordId, String ip, String name, String model, String login, String password, String url)
    {
        try {
            Statement stmt =  (Statement) con.obtainConnection().createStatement();
            String update = "UPDATE "+className+" SET ip='"+ip+"', name='"+name+"', model='"+model+"', login='"+login+"', password='"+password+"', url='"+url+"' where id='"+recordId+"'";
            stmt.executeUpdate(update);
        }
        catch(SQLException e)
        {
            throw new IllegalStateException("Connot insert into table!: "+e);
        }
    return "1";
    }


}
    

