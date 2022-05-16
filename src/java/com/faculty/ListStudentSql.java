
package com.faculty;

import com.test.dao.LoginDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListStudentSql 
{
    
    String url = "jdbc:mysql://localhost:3306/attendance";
    String username = "root";
    String password ="admin@1234";
    String[] list;
    String store = "";
    public String[] getList(String course)throws SQLException
    {
    
        try 
        {
            System.out.println("lsq " + course + " List Student Sql");
            String selected_course = selectCourse(course);
            //incomplete sql statement where add it using switch case
            String sql = "select roll, email, firstname, lastname from student where "+selected_course+" = ?";
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1,course);
            
            
            ResultSet rs = st.executeQuery();
            //System.out.println("false");
            //System.out.println(email + " "+pass);
            //System.out.println("faculty dao");
            if(rs.next())
            {
                
                 return list = new String[]{rs.getString("roll"),rs.getString("email"),rs.getString("firstname"),rs.getString("lastname")};
                
            }
            
            
        } catch (Exception ex) 
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public String selectCourse(String course) 
    {
        
        switch(course)
                {
            case "AI & ML": 
                store = "aiml";
                break;
                
            case "Advance Data Mining":
                store = "adm";
                break;
                
            case "Web Technology - Advance Java":
                store = "wtaj";
                break;
            case "Computer Oriented Optimization":
                store = "coo";
                break;
            case "Advanced Operating System":
                store = "optional";
                break;
                
            case "Cryptography and Network Security":
                store = "optional";
                break;
            default:
                System.out.println("Default String : "+store);
                }
        return store;
    }
    
}
