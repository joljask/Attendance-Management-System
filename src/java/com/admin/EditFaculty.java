package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditFaculty", urlPatterns = {"/EditFaculty"})
public class EditFaculty extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;characterset=UTF-8");

        String search = request.getParameter("search_email");

        String sql = "select * from faculty";
        String sql_query = "SELECT  * from faculty WHERE facultyid = ?";

        PrintWriter out = response.getWriter();
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");
            
            
            
            PreparedStatement stmt = con.prepareStatement(sql_query);
            
            stmt.setString(1,search);
            
            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                RequestDispatcher display = request.getRequestDispatcher("/editFaculty.jsp");
            display.include(request, response);
            out.println("<center><pre><h6>"+ search+ "</h6><h5> Not found in database.</h5></pre><p>Please enter correct Faculty ID.</p></center>");
            } else {
                while (rs.next()) {

                    System.out.println(rs.getString("email"));
                    System.out.println(rs.getString("firstname"));
                    System.out.println(rs.getString("lastname"));
                    System.out.println(rs.getString("facultyid"));
                    System.out.println(rs.getString("course"));
                    System.out.println(rs.getString("mobileno"));
                    System.out.println(rs.getString("password"));

                    
                    RequestDispatcher display = request.getRequestDispatcher("/editFaculty.jsp");
            display.include(request, response);
            out.println("<br><br><center>\n" +
"        <table>\n" +
"\n" +
"            <form action=\"EditInsertFaculty\" method=\"post\" >\n" +
"\n" +
"\n" +
                    "<tr><td class=\"form-table\"><label for=\"inputAddress\">Faculty ID : "+ rs.getString("facultyid")+"</label></td><td class=\"form-table\"><input type=\"hidden\" class=\"form-control\" id=\"inputAddress\"  name=\"f_id\" value = " + rs.getString("facultyid")+"></td></tr>"+
"                <tr>\n" +
"                    <td class=\"form-table\"><label for=\"inputAddress\">First Name</label></td>\n" +
"                    <td class=\"form-table\">      <input type=\"text\" class=\"form-control\" placeholder=\"First name\" name=\"f_first_name\" value = "+ rs.getString("firstname")+"> </td>\n" +
"                    <td class=\"form-table\"><label for=\"inputAddress\">Last Name</label></td>\n" +
"                    <td class=\"form-table\"><input type=\"text\" class=\"form-control\" placeholder=\"Last name\" name=\"f_last_name\" value = "+ rs.getString("lastname")+">  </td>\n" +
"                </tr>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"                <tr>\n" +
"                    <td class=\"form-table\"><label for=\"inputEmail4\">Email</label></td>\n" +
"                    <td class=\"form-table\"> <input type=\"email\" class=\"form-control\" id=\"inputEmail4\" placeholder=\"Email\" name=\"f_email\" value = "+ rs.getString("email")+"> </td>\n" +
"\n" +
"                    <td class=\"form-table\"><label for=\"inputAddress\">Mobile No.</label></td>\n" +
"                    <td class=\"form-table\"><input type=\"text\" class=\"form-control\" placeholder=\"Mobile Number\" name=\"f_mobile\" value = "+ rs.getString("mobileno")+"></td>\n" +
"                </tr>\n" +
"\n" +
"\n" +
"\n" +
"                <tr>\n" +

"\n" +
"                    <td class=\"form-table\"> <label for=\"inputState\">Select Course</label></td> \n" +
"                    <td class=\"form-table\">\n" +
"                        <select id=\"inputState\" class=\"form-control\" name = f_course >\n" +
"                            <option selected>"+ rs.getString("course")+"</option>\n" +
"                            <option>AI&ML</option> \n" +
"                            <option>Advance Data Mining</option>\n" +
"                            <option>Advanced Operating System</option>\n" +
"                            <option>Cryptography and Network Security</option>\n" +
"                            <option>Web Technology - Advance Java</option>\n" +
"                            <option>Computer Oriented Optimization</option>\n" +
"\n" +
"                        </select>\n" +
"                    </td>\n" +
"                </tr>\n" +
"\n" +
"                " +
"                <tr>\n" +
"                    <th colspan=\"4\" style=\"padding-left: 300px\"><button type=\"submit\" class=\"btn btn-primary\">Save</button></th>\n" +
"                </tr>\n" +
"\n" +
"            </form>\n" +
"        </table>\n" +
"    </center>");
                }
            }

            
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
