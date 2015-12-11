/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author alex
 */
public class sqlSelect {

    String user;
    sqlConnection con = new sqlConnection();
    public sqlSelect(){
        
        
    }
    public int[] obtainUserAccess(String user) { 
        int[] userAccess;
        String [] classesList;


//Get userAccessFields info from users table 
//VPN -0 
//Firewall 1
//Network/Wireless 2
//LinuxServers 3
//Windows Servers 4
//VMWareServers 5
//UPS 6
//Cloud -7  
//printers 8
//Applications 9


        try{
            String select = "SELECT * from classes where active='1'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            classesList = new String[rowCount];
            int i=0;

            while (rs.next())
            {
                classesList[i] = rs.getString("class");
                i++;
            }
            
             userAccess = new int[classesList.length];

            select = "SELECT * from users where user='"+user+"'";
            stmt = con.obtainConnection().createStatement();
            rs = stmt.executeQuery(select);
            i = 0;
            while (rs.next())
            {
                for (i = 0; i < classesList.length; i++)
                {
                userAccess[i] = rs.getInt(classesList[i]);
                }
           
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return userAccess;
    }
public String [] obtainUsersList() { 
        String [] usersList;
        
        
        try{
            String select = "SELECT * from users";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            usersList = new String[rowCount];
            int i=0;

            while (rs.next())
            {
                usersList[i] = rs.getString("user");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return usersList;
    }

public String [] obtainClassesList() { 
        String [] classesList;
        
        
        try{
            String select = "SELECT * from classes where active='1'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            classesList = new String[rowCount];
            int i=0;

            while (rs.next())
            {
                classesList[i] = rs.getString("class");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return classesList;
    }
    


    public String[] obtainDataISP() { 
        String[] userArray;
        userArray = new String[5];

        try{
            String select = "SELECT * from isp";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next())
            {
                userArray[0] = rs.getString("id");
                userArray[1] = rs.getString("tableName");
                userArray[2]= rs.getString("name");
                userArray[3] = rs.getString("portDown");
                userArray[4] = rs.getString("phone");
                
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return userArray;
    }
    
    
public String[] obtainDataFirewall() { 
        String[] userArray;
        userArray = new String[5];
        
        
        
        try{
            String select = "SELECT * from firewall";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next())
            {
                userArray[0] = rs.getString("id");
                userArray[1] = rs.getString("tableName");
                userArray[2]= rs.getString("name");
                userArray[3] = rs.getString("portDown1");
                userArray[4] = rs.getString("portDown2");
                
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return userArray;
    }
    
    public String[] obtainDataPath() { 
        String[] userArray;
        userArray = new String[5];
        
        
        
        try{
            String select = "SELECT * from path";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next())
            {
                userArray[0] = rs.getString("id");
                userArray[1] = rs.getString("path");
                
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return userArray;
    }

public String obtainPassword(String user) { 
        String userPassword = "1";
        
        try{
            String select = "SELECT * from users where user='"+user+"' and active=1";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next())
            {
                userPassword= rs.getString("password");
                
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return userPassword;
    }


public String[] obtainCompanies() { 
        String[] companies;
        
        try{
            String select = "SELECT * from companies where active='1'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            companies = new String[rowCount];
            int i=0;
            while (rs.next())
            {
                companies[i]= rs.getString("company");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return companies;
    }
public int[] obtainCompaniesId() { 
        int[] companiesId;
        
        try{
            String select = "SELECT * from companies where active='1'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            companiesId = new int[rowCount];
            int i=0;
            while (rs.next())
            {
                companiesId[i]= rs.getInt("id");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return companiesId;
    }
public int checkFirewallInfo(int companyId, int siteId) { 
        int recordId;
        recordId = 0;
    
        try{
            String select = "SELECT * from firewall where companyId='"+companyId+"' and siteId='"+siteId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next())
            {
                recordId = rs.getInt("id");
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return recordId;
    }


public String[][] obtainFirewallInfo(int companyId, int siteId) { 
        String[] ip;
        String[] name;
        String[] model;
        String[] login;
        String[] password;
        String[] url;
        
        try{
            String select = "SELECT * from firewall where companyId='"+companyId+"' and siteId='"+siteId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            ip = new String[rowCount];
            name = new String[rowCount];
            model = new String[rowCount];
            login = new String[rowCount];
            password = new String[rowCount];
            url = new String[rowCount];
            int i=0;
            
            while (rs.next())
            {
                ip[i]= rs.getString("ip");
                name[i]= rs.getString("name");
                model[i]= rs.getString("model");
                login[i]= rs.getString("login");
                password[i]= rs.getString("password");
                url[i]= rs.getString("url");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return new String[][] {ip, name, model, login, password, url};
    }

public int checkClassInfo(int companyId, int siteId, String classType) { 
        int recordId;
        recordId = 0;
    
        try{
            String select = "SELECT * from "+classType+" where companyId='"+companyId+"' and siteId='"+siteId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next())
            {
                recordId = rs.getInt("id");
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return recordId;
    }


public String[][] obtainClassInfo(int companyId, int siteId, String className) { 
        String[] ip;
        String[] name;
        String[] model;
        String[] login;
        String[] password;
        String[] url;
        
        try{
            String select = "SELECT * from "+className+" where companyId='"+companyId+"' and siteId='"+siteId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            ip = new String[rowCount];
            name = new String[rowCount];
            model = new String[rowCount];
            login = new String[rowCount];
            password = new String[rowCount];
            url = new String[rowCount];
            int i=0;
            
            while (rs.next())
            {
                ip[i]= rs.getString("ip");
                name[i]= rs.getString("name");
                model[i]= rs.getString("model");
                login[i]= rs.getString("login");
                password[i]= rs.getString("password");
                url[i]= rs.getString("url");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return new String[][] {ip, name, model, login, password, url};
    }
public String[] obtainClassRecord(int companyId, int siteId, String className, int recordId) { 
        String ip = "";
        String name = "";
        String model = "";
        String login ="";
        String password="";
        String url="";
        
        try{
            String select = "SELECT * from "+className+" where companyId='"+companyId+"' and siteId='"+siteId+"' and id='"+recordId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
           
            while (rs.next())
            {
                ip = rs.getString("ip");
                name = rs.getString("name");
                model = rs.getString("model");
                login = rs.getString("login");
                password = rs.getString("password");
                url = rs.getString("url");
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return new String[] {ip, name, model, login, password, url};
    }


public String[][] obtainClassInfoAndId(int companyId, int siteId, String className) { 
        String[] ip;
        String[] name;
        String[] model;
        String[] login;
        String[] password;
        String[] url;
        String[] id;
        
        try{
            String select = "SELECT * from "+className+" where companyId='"+companyId+"' and siteId='"+siteId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            ip = new String[rowCount];
            name = new String[rowCount];
            model = new String[rowCount];
            login = new String[rowCount];
            password = new String[rowCount];
            url = new String[rowCount];
            id = new String[rowCount];
            int i=0;
            
            while (rs.next())
            {
                ip[i]= rs.getString("ip");
                name[i]= rs.getString("name");
                model[i]= rs.getString("model");
                login[i]= rs.getString("login");
                password[i]= rs.getString("password");
                url[i]= rs.getString("url");
                id[i] = rs.getString("id");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return new String[][] {ip, name, model, login, password, url, id};
    }

public int[] obtainSitesID(int companyId) { 
        int [] siteId;
    
        try{
            String select = "SELECT * from sites where companyId='"+companyId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            siteId = new int[rowCount];
            int i = 0;
            while (rs.next())
            {
                siteId[i]= rs.getInt("id");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return siteId;
    }
public String[] obtainSitesName(int companyId) { 
        String [] siteName;
    
        try{
            String select = "SELECT * from sites where companyId='"+companyId+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            siteName = new String[rowCount];
            int i = 0;
            while (rs.next())
            {
                siteName[i]= rs.getString("name");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return siteName;
    }

public int obtainCompanyID(String company) { 
        int companyId;
        companyId = 0;
        
        try{
            String select = "SELECT * from companies where company='"+company+"'";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            while (rs.next())
            {
                companyId= rs.getInt("id");
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return companyId;
    }


public String [] obtainCompaniesList() { 
        String [] companiesList;
        
        
        try{
            String select = "SELECT * from companies";
            Statement stmt = con.obtainConnection().createStatement();
            ResultSet rs = stmt.executeQuery(select);
            int rowCount = 0;
            if (rs.last())
            {
                rowCount = rs.getRow();
                rs.beforeFirst();
            }
            companiesList = new String[rowCount];
            int i=0;

            while (rs.next())
            {
                companiesList[i] = rs.getString("company");
                i++;
            }
        }
        catch (SQLException e)
        {
            throw new IllegalStateException ("Cannot select from table!"+e);
        }
      
        return companiesList;
    }




public String obtainData() { return user;}

}
