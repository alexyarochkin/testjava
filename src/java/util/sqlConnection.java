/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alex
 */
public class sqlConnection {
Connection con;

    public sqlConnection(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
          catch (ClassNotFoundException e) {
          System.err.println(e);          
        }
    
        String url = "jdbc:mysql://localhost:3306/talachabee";
        String username = "root";
        String password = "";
        
        try {
            con=DriverManager.getConnection(url, username, password);
            } 
        catch (SQLException e)
        {
            throw new IllegalStateException("Cannot connect to database!"+e);
        }
        
    }
    //Methid obtainConnection();
    
     Connection obtainConnection() {return con;}

}
