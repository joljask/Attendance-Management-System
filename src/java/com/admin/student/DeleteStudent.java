package com.admin.student;

import com.admin.DeleteFaculty;
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

@WebServlet(name = "DeleteStudent", urlPatterns = {"/DeleteStudent"})
public class DeleteStudent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String search = request.getParameter("search_facultyid");

        String sql_query = "SELECT  roll, firstname, lastname, email, mobileno from student WHERE roll = ?";

        PrintWriter out = response.getWriter();

        try {
            System.out.println("hello");
            String facultyid = "";

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");

            PreparedStatement stmt = con.prepareStatement(sql_query);

            stmt.setString(1, search);

            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                RequestDispatcher display = request.getRequestDispatcher("/deleteStudent.jsp");
                display.include(request, response);
                out.println("<center><pre><h6>" + search + "</h6><h5> Not found in database.</h5></pre><p>Please enter correct Student rollno.</p></center>");
            } else {
                while (rs.next()) {

                    //rs.next();
                    //System.out.println(rs.getString("email"));
                    RequestDispatcher display = request.getRequestDispatcher("/deleteStudent.jsp");
                    display.include(request, response);

                    out.println("<br><br><center><table><form action=\"DeleteSqlStudent\" method=\"post\">\n"
                            + "        <tr>\n"
                            + "            <th class=\"delete-th\">Roll No.</th>\n"
                            + "            <th class=\"delete-th\">Email</th>\n"
                            + "            <th class=\"delete-th\">First Name</th>\n"
                            + "            <th class=\"delete-th\">Last Name</th>\n"
                            + "            "
                            + "            <th class=\"delete-th\">Mobile Number</th>\n"
                            + "<th style=\"border-right: hidden; border-top: hidden; border-bottom: hidden; \"><input type=\"hidden\" name=\"facultyid\" value=\"" + rs.getString("roll") + "\"></th>"
                            + "        </tr>\n"
                            + "        <tr>\n"
                            + "            <td class=\"delete-td\">" + rs.getString("roll") + "</td>\n"
                            + "            <td class=\"delete-td\">" + rs.getString("email") + "</td>\n"
                            + "            <td class=\"delete-td\">" + rs.getString("firstname") + "</td>\n"
                            + "            <td class=\"delete-td\">" + rs.getString("lastname") + "</td>\n"
                            + "            "
                            + "            <td class=\"delete-td\">" + rs.getString("mobileno") + "</td>\n"
                            + "            <td style=\"border-right: hidden; border-top: hidden; border-bottom: hidden; \"><button class=\"btn btn-primary\">DELETE</button></td>\n"
                            + "        </tr>\n"
                            + "    </form></table></center>");
                }
                
                con.close();

            }
        } catch (Exception ex) {
            Logger.getLogger(DeleteFaculty.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
