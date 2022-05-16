
package com.admin.student;

import com.admin.EditInsertFaculty;
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


@WebServlet(name = "EditInsertStudent", urlPatterns = {"/EditInsertStudent"})
public class EditInsertStudent extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        
        String email = request.getParameter("f_email");
        String first_name = request.getParameter("f_first_name");
        String last_name = request.getParameter("f_last_name");
        String faculty_id = request.getParameter("f_id");
        String faculty_course = request.getParameter("optional");
        String faculty_mobile_no = request.getParameter("f_mobile");

        System.out.println("Fetched Data are");
        System.out.println(email + first_name + last_name + faculty_id + faculty_course + faculty_mobile_no);
        
        try {
            String sql_query = "UPDATE student SET firstname = ?, lastname = ? ,email = ?, optional = ?, mobileno = ?  WHERE roll = ?";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");

            PreparedStatement stmt = con.prepareStatement(sql_query);
           // PreparedStatement stmt = con.prepareStatement("UPDATE student SET firstname = 'student004', lastname = 'title' ,email = 'student@gmail.com', course = 'abc', mobileno = '1234567890'  WHERE roll = 3");

            stmt.setString(6, faculty_id);
            stmt.setString(3, email);
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            
            stmt.setString(4, faculty_course);
            stmt.setString(5, faculty_mobile_no);

            int i = stmt.executeUpdate();
            System.out.println(i + " records updated");
            
            
            
            response.sendRedirect("editStudentSuccess.jsp");
            

        } catch (Exception ex) {
            Logger.getLogger(EditInsertFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
