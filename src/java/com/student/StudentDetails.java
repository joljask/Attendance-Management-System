
package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentDetails 
{
    String url = "jdbc:mysql://localhost:3306/attendance";
            String username = "root";
            String password = "admin@1234";
    public String getStudentName(String email) throws ClassNotFoundException, SQLException 
    {
        System.out.println(email);
        
        String sql = "select firstname, lastname from student where email =?";
        String student_name = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
            
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(sql);
                
                st.setString(1, email);
                ResultSet rs = st.executeQuery();
                rs.next();
                student_name = rs.getString("firstname") + " "+rs.getString("lastname");
      return student_name;  
    }
    public String getStudentRoll(String email) throws ClassNotFoundException, SQLException 
    {
        System.out.println(email);
        
        String sql = "select roll from student where email =?";
        String student_roll = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
            
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(sql);
                
                st.setString(1, email);
                ResultSet rs = st.executeQuery();
                rs.next();
                student_roll = rs.getString("roll");
      return student_roll;  
    }
    
    
    
    public ArrayList getStudentSubjects(String email) throws ClassNotFoundException, SQLException 
    {
        ArrayList<String> student_course_list =new ArrayList<String>();
         String sql = "select aiml,adm,wtaj,coo,optional from student where email = ?";
         Class.forName("com.mysql.cj.jdbc.Driver");
            
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(sql);
                
                st.setString(1, email);
                ResultSet rs = st.executeQuery();
               rs.next();
                
                    student_course_list.add(rs.getString("aiml"));
                    student_course_list.add(rs.getString("adm"));
                    student_course_list.add(rs.getString("coo"));
                    student_course_list.add(rs.getString("optional"));
                
                
              return student_course_list;  
    }
    
    public String getFacultyId(String course) throws ClassNotFoundException, SQLException 
    {
        String facultyid;
        String sql = "select facultyid from faculty where course =?";
        Class.forName("com.mysql.cj.jdbc.Driver");
            
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(sql);
                
                 st.setString(1, course);
                ResultSet rs = st.executeQuery();
               rs.next();
               facultyid = rs.getString("facultyid");
               return facultyid;
    }
    
    
}
