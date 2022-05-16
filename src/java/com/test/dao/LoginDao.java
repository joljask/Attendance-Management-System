
package com.test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoginDao 
{
    String sql = "select * from adminLogin where emailID=? and pass=?";
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
            
            if(rs.next())
            {
                return true;
            }
            
            
        } catch (Exception ex) 
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
        return false;
    }
}
