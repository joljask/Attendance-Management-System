
package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FacultyDao 
{
    String sql = "select * from faculty where email=? and password=?";
    String url = "jdbc:mysql://localhost:3306/attendance";
    String username = "root";
    String password ="admin@1234";
    
    public boolean check(String email, String pass) throws SQLException
    {
        
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1,email);
            st.setString(2,pass);
            
            ResultSet rs = st.executeQuery();
            //System.out.println("false");
            //System.out.println(email + " "+pass);
            //System.out.println("faculty dao");
            if(rs.next())
            {
                //System.out.println("true");
                return true;
            }
            
            
        } catch (Exception ex) 
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
        return false;
    }
}
