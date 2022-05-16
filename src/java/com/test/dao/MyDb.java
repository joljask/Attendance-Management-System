
package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyDb {
    Connection con;
    public Connection getCon() throws SQLException
    {
        try {
            System.out.println("MyDb file !!!!");
            Class.forName("com.mysql.cj.jdbc.Driver");
            DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","admin@1234");
           System.out.println("mydb working");
          
            
        } 
        
        catch (ClassNotFoundException ex) {
            Logger.getLogger(MyDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return con;
    }
}
