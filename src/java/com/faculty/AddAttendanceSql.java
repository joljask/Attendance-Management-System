package com.faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AddAttendanceSql", urlPatterns = {"/AddAttendanceSql"})
public class AddAttendanceSql extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] rolls = request.getParameterValues("rolls");
        String[] attendance_value = request.getParameterValues("att");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        AttendanceUpdate au = new AttendanceUpdate();
        try {
            au.updateDatabase(rolls, attendance_value, email);
        } catch (SQLException ex) {
            Logger.getLogger(AddAttendanceSql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AddAttendanceSql.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < attendance_value.length; i++) {
            System.out.println(rolls[i] + " " + attendance_value[i]);
        }

        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <!-- Success api -->\n"
                    + "        <link href=\"https://fonts.googleapis.com/css?family=Nunito+Sans:400,400i,700,900&display=swap\" rel=\"stylesheet\">\n"
                    + "        <!-- Bootstrap CSS -->\n"
                    + "        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
                    + "              integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
                    + "        \n"
                    + "        <!-- Javascript -->\n"
                    + "  <script src=\"js/admin.js\"></script>\n"
                    + "  <style>\n"
                    + "            body {\n"
                    + "                text-align: center;\n"
                    + "                padding: 40px 0;\n"
                    + "                background: #EBF0F5;\n"
                    + "            }\n"
                    + "            h1 {\n"
                    + "                color: #88B04B;\n"
                    + "                font-family: \"Nunito Sans\", \"Helvetica Neue\", sans-serif;\n"
                    + "                font-weight: 900;\n"
                    + "                font-size: 40px;\n"
                    + "                margin-bottom: 10px;\n"
                    + "            }\n"
                    + "            p {\n"
                    + "                color: #404F5E;\n"
                    + "                font-family: \"Nunito Sans\", \"Helvetica Neue\", sans-serif;\n"
                    + "                font-size:20px;\n"
                    + "                margin: 0;\n"
                    + "            }\n"
                    + "            i {\n"
                    + "                color: #9ABC66;\n"
                    + "                font-size: 100px;\n"
                    + "                line-height: 200px;\n"
                    + "                margin-left:-15px;\n"
                    + "            }\n"
                    + "            .card {\n"
                    + "                background: white;\n"
                    + "                padding: 60px;\n"
                    + "                border-radius: 4px;\n"
                    + "                box-shadow: 0 2px 3px #C8D0D8;\n"
                    + "                display: inline-block;\n"
                    + "                margin: 0 auto;\n"
                    + "            }\n"
                    + "        </style>\n"
                    + "        <title>Attendance Portal</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <div class=\"card\">\n"
                    + "            <div style=\"border-radius:200px; height:200px; width:200px; background: #F8FAF5; margin:0 auto;\">\n"
                    + "                <i class=\"checkmark\">✓</i>\n"
                    + "            </div>\n"
                    + "            <h1>Success</h1> \n"
                    + "            <p>Successfully modified student details;<br/></p>\n"
                    + "            <button type=\"button\" class=\"btn btn-primary\" onclick=\"openPage('faculty.jsp')\">Go to Dashboard</button><!-- add faculty -->\n"
                    + "        </div>\n"
                    + "    </body>\n"
                    + "</html>");

        }
    }

}
