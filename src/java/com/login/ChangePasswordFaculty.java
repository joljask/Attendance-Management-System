
package com.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ChangePasswordFaculty", urlPatterns = {"/ChangePasswordFaculty"})
public class ChangePasswordFaculty extends HttpServlet {

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;characterset=UTF-8");
        
        

        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");
        
        System.out.println(pass1 + pass2);
        
        PrintWriter out = response.getWriter();
        
        String email = (String)request.getParameter("sendEmail");
        System.out.println(email + "from faculty login");
        
        //String var1email = (String)request.getAttribute("sendEmail");
        //System.out.println(var1email + "from faculty login");
        
        //String varemail =  "joe@gmail.com";
        
        String sql_query = "UPDATE faculty SET password = ?  WHERE email = ?";
        
        try
        {
            if(pass1.equals(pass2))
        {
            System.out.println("password changes");
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");

            PreparedStatement stmt = con.prepareStatement(sql_query);
            
            stmt.setString(1, pass1);
            stmt.setString(2,email);
            
            int i = stmt.executeUpdate();
            System.out.println(i + " records inserted");
        
            
            response.sendRedirect("faculty.jsp");
        }
        else
        {
            RequestDispatcher display = request.getRequestDispatcher("/changePasswordFaculty.jsp");
            display.include(request, response);
            out.println("<br><br><br><br><center<h5 style=\"margin-left:485px;color:red; font-size:25px\">Password does not match.</h5></center>");
        }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    

}
