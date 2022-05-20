
package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DeleteFaculty", urlPatterns = {"/DeleteFaculty"})
public class DeleteFaculty extends HttpServlet {

  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;characterset=UTF-8");

        String search = request.getParameter("search_facultyid");

        String sql = "select * from faculty";
        String sql_query = "SELECT  * from faculty WHERE facultyid = ?";

        PrintWriter out = response.getWriter();
        
        try 
        {
            String facultyid = "";
             
            Class.forName("com.mysql.cj.jdbc.Driver");
              
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");
            
            
            
            PreparedStatement stmt = con.prepareStatement(sql_query);
            
            stmt.setString(1,search);
            
            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                RequestDispatcher display = request.getRequestDispatcher("/deleteFaculty.jsp");
            display.include(request, response);
            out.println("<center><pre><h6>"+ search+ "</h6><h5> Not found in database.</h5></pre><p>Please enter correct Faculty ID.</p></center>");
            } else
            {
                while (rs.next()) 
                {

                    System.out.println(rs.getString("email"));
                    System.out.println(rs.getString("firstname"));
                    System.out.println(rs.getString("lastname"));
                    System.out.println(rs.getString("facultyid"));
                    System.out.println(rs.getString("course"));
                    System.out.println(rs.getString("mobileno"));
                    System.out.println(rs.getString("password"));

                    
                    RequestDispatcher display = request.getRequestDispatcher("/deleteFaculty.jsp");
            display.include(request, response);
            
            
            
            
            
            out.println("<br><br><center><table><form action=\"DeleteSqlFaculty\" method=\"post\">\n" +
"        <tr>\n" +
"            <th class=\"delete-th\">Faculty ID</th>\n" +
"            <th class=\"delete-th\">Email</th>\n" +
"            <th class=\"delete-th\">First Name</th>\n" +
"            <th class=\"delete-th\">Last Name</th>\n" +
"            <th class=\"delete-th\">Course</th>\n" +
"            <th class=\"delete-th\">Mobile Number</th>\n" +
                    "<th style=\"border-right: hidden; border-top: hidden; border-bottom: hidden; \"><input type=\"hidden\" name=\"facultyid\" value=\""+ rs.getString("facultyid")+"\"></th>"+
"        </tr>\n" +
"        <tr>\n" +
"            <td class=\"delete-td\">"+rs.getString("facultyid")+"</td>\n" +
"            <td class=\"delete-td\">"+rs.getString("email")+"</td>\n" +
"            <td class=\"delete-td\">"+rs.getString("firstname")+"</td>\n" +
"            <td class=\"delete-td\">"+rs.getString("lastname")+"</td>\n" +
"            <td class=\"delete-td\">"+rs.getString("course")+"</td>\n" +
"            <td class=\"delete-td\">"+rs.getString("mobileno")+"</td>\n" +
"            <td style=\"border-right: hidden; border-top: hidden; border-bottom: hidden; \"><button class=\"btn btn-primary\">DELETE</button></td>\n" +
"        </tr>\n" +
"    </form></table></center>");
            }
                
        }
        }
        catch (Exception ex) {
                 Logger.getLogger(DeleteFaculty.class.getName()).log(Level.SEVERE, null, ex);
             }
    }

    

}
