
package com.admin.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "DeleteSqlStudent", urlPatterns = {"/DeleteSqlStudent"})
public class DeleteSqlStudent extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String facultyid = request.getParameter("facultyid");
      System.out.println("delete sql faculty " + facultyid); 
      
      String sql_query = "DELETE FROM student WHERE roll = ?";
      
      try
      {
          Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");

            PreparedStatement stmt = con.prepareStatement(sql_query);
           
            stmt.setString(1, facultyid);
            
            int i = stmt.executeUpdate();
            System.out.println(i + " record deleted.");
            
           
            
            response.sendRedirect("deleteStudentSuccess.jsp");

      }
      catch(Exception e)
      {
          System.out.println(e);
      }
    }

    

}
