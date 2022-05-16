package com.faculty;

import com.test.dao.LoginDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetFacultyCourse {
    

        String url = "jdbc:mysql://localhost:3306/attendance";
        String username = "root";
        String password = "admin@1234";
        String sql_faculty = "select facultyid,course  from faculty where email = ?";
        String[] faculty_course;

    public String[] getFacultyCourse(String email) throws SQLException 
    {
        try 
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            PreparedStatement st = con.prepareStatement(sql_faculty);
            
            st.setString(1,email);
            
            
            ResultSet rs = st.executeQuery();
            
            if(rs.next())
            {
                faculty_course = new String[]{rs.getString("facultyid"),rs.getString("course")};
            }
            else
            {
                System.out.println("Course not found");
            }
            
            
        } catch (Exception ex) 
        {
            Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        
        
        return faculty_course;
    }
}
