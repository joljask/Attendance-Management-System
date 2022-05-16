
package com.faculty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;


public class AttendanceUpdate
{
    public void updateDatabase(String [] rolls, String [] atts,String email) throws SQLException, ClassNotFoundException
    {
        String url = "jdbc:mysql://localhost:3306/attendance";
        String username = "root";
        String password = "admin@1234";
        String store = "";
        
       
        
        String insert_attendance = "insert into attendance values (?,?,?,?,CURDATE(),NOW())";
        
        
        
        GetFacultyCourse fetch_faculty_course = new GetFacultyCourse();
            String[] faculty_course = fetch_faculty_course.getFacultyCourse(email);
            System.out.println(faculty_course[0] + " : facultyid"); //working
            System.out.println(faculty_course[1] + " : faculty course");//working
            
         ListStudentSql lss = new ListStudentSql();
            store = lss.selectCourse(faculty_course[1]);
            
            
        Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
        
        for(int i=0;i<rolls.length;i++)
        {
             PreparedStatement st = con.prepareStatement(insert_attendance);

                st.setString(1,faculty_course[0] );
                st.setString(2,rolls[i].replaceAll("\\s", "") );
                st.setBoolean(3,valueSearch(atts, rolls[i]));
                st.setString(4, store);
                
                st.executeUpdate();
            System.out.println(i + " records inserted");
                
            System.out.println("update database :" + rolls[i] + "  " + valueSearch(atts, rolls[i]));
        }
        
    }
    
    boolean valueSearch(String[] atts, String  search)
    {
        for(int i =0;i<atts.length;i++)
        {
            if(atts[i].replaceAll("\\s", "").equals(search.replaceAll("\\s", "")))
                return true;
        }
        
        return false;
    }
}
