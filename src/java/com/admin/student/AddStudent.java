
package com.admin.student;

import com.admin.AddFaculty;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AddStudent", urlPatterns = {"/AddStudent"})
public class AddStudent extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("f_email");
        String first_name = request.getParameter("f_first_name");
        String last_name = request.getParameter("f_last_name");
        String student_roll = request.getParameter("f_id");
        String faculty_course = request.getParameter("aiml");
        String faculty_mobile_no = request.getParameter("f_mobile");
        String faculty_default_password = "Test@123";
        String aiml = request.getParameter("aiml");
        String adm = request.getParameter("adm");
        String wtaj = request.getParameter("wtaj");
        String coo = request.getParameter("coo");
        String optional = request.getParameter("optional");
        
        System.out.println(aiml);
        System.out.println(adm);
        System.out.println(wtaj);
        System.out.println(coo);
        System.out.println(optional);
         try {
            
            String sql = "insert into student values(?,?,?,?,?,?,?,?,?,?,?)";
            
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance","root","admin@1234");
         
            
             
           System.out.println("mydb working");
            
            PreparedStatement stmt = con.prepareStatement(sql);

            

            stmt.setString(1, student_roll);
            stmt.setString(2, email);
            stmt.setString(3, first_name);
            stmt.setString(4, last_name);
            
            //stmt.setString(5, faculty_course);
            stmt.setString(5, faculty_mobile_no);
            stmt.setString(6, faculty_default_password);
            stmt.setString(7,aiml);
            stmt.setString(8,adm);
            stmt.setString(9,wtaj);
            stmt.setString(10,coo);
            stmt.setString(11,optional);
           
            
            
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");
            
            response.sendRedirect("addStudentSuccess.jsp");

            con.close();

        } catch (Exception ex) {
            Logger.getLogger(AddFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
