
package com.login;

import com.test.dao.FacultyDao;
import com.test.dao.StudentDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "StudentLogin", urlPatterns = {"/StudentLogin"})
public class StudentLogin extends HttpServlet {

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;characterset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("id");
        String pass = request.getParameter("pass");
        //System.out.println("FacultyLogin");
        //System.out.println(email+pass);

        String default_password = "Test@123";

        StudentDao dao = new StudentDao();

        //request.setAttribute("sendEmail", email);
        //RequestDispatcher rd = request.getRequestDispatcher("/ChangePasswordFaculty");
        //rd.forward(request, response);
        try {
            if (dao.check(email, pass)) {
                HttpSession session = request.getSession();

                if (default_password.equals(pass)) {
                    System.out.println("change Password");
                    request.setAttribute("sendEmail", email);
                    RequestDispatcher rd;
                    rd = request.getRequestDispatcher("/changePasswordStudent.jsp");
                    rd.include(request, response);
                    //response.sendRedirect("changePasswordFaculty.jsp");

                    out.println("<form action=\"ChangePasswordStudent\" method=\"post\">\n"
                            + "            <div id=\"container\">\n"
                            + "\n"
                            + "                <div id=\"header\">\n"
                            + "                    <center><h1>Change Password</h1></center>\n"
                            + "                </div> \n"
                            + "\n     <input type=\"hidden\" id=\"custId\" name=\"sendEmail\" value=\""+email+"\">"
                            + "\n"
                            + "\n"
                            + "\n"
                            + "                <div id=\"form\">\n"
                            + "                    <input type=\"password\" placeholder=\"New Password\" id=\"passOne\" name=\"pass1\"/>\n"
                            + "                    <input type=\"password\" placeholder=\"Confirm Password\" id=\"passTwo\" name=\"pass2\"/>\n"
                            + "                </div>\n"
                            + "                <div id=\"footer\" class=\"incorrect\" >\n"
                            + "                    <center> <button type=\"submit\" class=\"reset1\">SUBMIT</button></center>\n"
                            + "                </div>\n"
                            + "\n"
                            + "            </div>\n"
                            + "        </form>");
                } else {
                    session.setAttribute("student_email", email);
                    response.sendRedirect("StudentPage");
                }

            } else {
                response.sendRedirect("student.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
