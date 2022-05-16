package com.admin.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditStudent", urlPatterns = {"/EditStudent"})
public class EditStudent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String search = request.getParameter("search_email");

        String sql_query = "SELECT  roll, firstname, lastname, email, mobileno,optional from student WHERE roll = ?";

        PrintWriter out = response.getWriter();

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance", "root", "admin@1234");

            PreparedStatement stmt = con.prepareStatement(sql_query);

            stmt.setString(1, search);

            ResultSet rs = stmt.executeQuery();

            if (!rs.isBeforeFirst()) {
                RequestDispatcher display = request.getRequestDispatcher("/editStudent.jsp");
                display.include(request, response);
                out.println("<center><pre><h6>" + search + "</h6><h5> Not found in database.</h5></pre><p>Please enter correct Student rollno.</p></center>");
            } else {
                while (rs.next()) {

                   

                    RequestDispatcher display = request.getRequestDispatcher("/editStudent.jsp");
                    display.include(request, response);
                    out.println("<br><br><center>\n"
                            + "        <table>\n"
                            + "\n"
                            + "            <form action=\"EditInsertStudent\" method=\"post\" >\n"
                            + "\n"
                            + "\n"
                            + "<tr><td><label for=\"inputAddress\">Roll No : " + rs.getString("roll") + "</label></td><td><input type=\"hidden\" class=\"form-control\" id=\"inputAddress\"  name=\"f_id\" value = " + rs.getString("roll") + "></td></tr>"
                            + "                <tr>\n"
                            + "                    <td><label for=\"inputAddress\">First Name</label></td>\n"
                            + "                    <td>      <input type=\"text\" class=\"form-control\" placeholder=\"First name\" name=\"f_first_name\" value = " + rs.getString("firstname") + "> </td>\n"
                            + "                    <td><label for=\"inputAddress\">Last Name</label></td>\n"
                            + "                    <td><input type=\"text\" class=\"form-control\" placeholder=\"Last name\" name=\"f_last_name\" value = " + rs.getString("lastname") + ">  </td>\n"
                            + "                </tr>\n"
                            + "\n"
                            + "\n"
                            + "\n"
                            + "\n"
                            + "                <tr>\n"
                            + "                    <td><label for=\"inputEmail4\">Email</label></td>\n"
                            + "                    <td> <input type=\"email\" class=\"form-control\" id=\"inputEmail4\" placeholder=\"Email\" name=\"f_email\" value = " + rs.getString("email") + "> </td>\n"
                            + "\n"
                            + "                    <td><label for=\"inputAddress\">Mobile No.</label></td>\n"
                            + "                    <td><input type=\"text\" class=\"form-control\" placeholder=\"Mobile Number\" name=\"f_mobile\" value = " + rs.getString("mobileno") + "></td>\n"
                            + "                </tr>\n"
                            + "\n"
                            + "\n"
                            + "\n"
                            + "                <tr>\n"
                            + "\n"
                            + "                    <td> <label for=\"inputState\">Optional Course</label></td> \n"
                            + "                    <td>\n"
                            + "                        <select id=\"inputState\" class=\"form-control\" name = \"optional\" >\n"
                            + "                            <option selected>" + rs.getString("optional") + "</option>\n"
                            + "                             \n"
                            + "                            "
                            + "                            <option>Advanced Operating System</option>\n"
                            + "                            <option>Cryptography and Network Security</option>\n"
                            + "                           "
                            + "                         "
                            + "\n"
                            + "                        </select>\n"
                            + "                    </td>\n"
                            + "                </tr>\n"
                            + "\n"
                            + "                <tr>\n"
                            + "                    \n"
                            + "                    <td colspan=\"4\" style=\"padding-left: 200px\">\n"
                            + "                        <div class=\"form-group\">\n"
                            + "                            <div class=\"form-check\">\n"
                            + "                                <input class=\"form-check-input\" type=\"checkbox\" id=\"gridCheck\">\n"
                            + "                                <label class=\"form-check-label\" for=\"gridCheck\">\n"
                            + "                                    Check if details filled correctly\n"
                            + "                                </label>\n"
                            + " \n"
                            + "                    </td>\n"
                            + "                    \n"
                            + "                </tr>\n"
                            + "                <tr>\n"
                            + "                    <th colspan=\"4\" style=\"padding-left: 200px\"><button type=\"submit\" class=\"btn btn-primary\">Save</button></th>\n"
                            + "                </tr>\n"
                            + "\n"
                            + "            </form>\n"
                            + "        </table>\n"
                            + "    </center>");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
