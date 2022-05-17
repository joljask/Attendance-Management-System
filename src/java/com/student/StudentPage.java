package com.student;

import com.faculty.GetAttendance;
import com.faculty.ListStudentSql;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "StudentPage", urlPatterns = {"/StudentPage"})
public class StudentPage extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */

            HttpSession session = request.getSession();

            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");

            if (session.getAttribute("student_email") == null) {
                response.sendRedirect("student.jsp");
            }

            String email = (String) session.getAttribute("student_email");

            // fetch student name using student email
            StudentDetails sd = new StudentDetails();
            ListStudentSql lss = new ListStudentSql();
            GetAttendance ga = new GetAttendance();

            //Subject names
            ArrayList<String> student_course_list = new ArrayList<String>();
            student_course_list = sd.getStudentSubjects(email);

            //for(int i = 0;i<sd.getSubjects().size();i++)
            System.out.println();

            out.println("<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "    <head>\n"
                    + "        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        <link rel=\"stylesheet\" href=\"css/student.css\">\n"
                    + "<!-- For logout button -->\n"
                    + "        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n"
                    + "        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n"
                    + "        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>"
                    + "        <title>Attendance Portal</title>\n"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "        <center>\n"
                    + "            <h1>Welcome, " + sd.getStudentName(email) + "</h1>\n"
                    + "<form action=\"StudentLogout\" method=\"post\">\n"
                    + "            <button  style=\"margin-left: 5px;\" type=\"submit\" class=\"btn btn-danger \">\n"
                    + "                <span class=\"glyphicon glyphicon-log-out\"></span> Log out\n"
                    + "            </button>"
                    + "        <table class=\"content-detail\">\n"
                    + "            <tr>\n"
                    + "                <td><h5 class=\"details\">Roll No :</h5></td>\n"
                    + "                <td class=\"time-border-right-details\"><h5 class=\"details\">" + sd.getStudentRoll(email) + "</h5></td>\n"
                    + "                <td><h5 class=\"details\">Name :</h5></td>\n"
                    + "                <td class=\"time-border-right-details\"><h5 class=\"details\">" + sd.getStudentName(email) + "</h5></td>\n"
                    + "                <td><h5 class=\"details\">Email :</h5></td>\n"
                    + "                <td><h5 class=\"details\">" + email + "</h5></td>\n"
                    + "            </tr>\n"
                    + "        </table>\n"
                    + "        </center>\n"
                    + "    <br>\n"
                    + "    <center>\n"
                    + "        <table class=\"content\">\n"
                    + "            <tr>\n"
                    + "                <td class=\"try time-border-right time-border-head\"><h5 class=\"heading-align\">Subject</h5></td>\n"
                    + "                <td class=\"try time-border-right time-border-head\"><h5 class=\"heading-align\">Classes Conducted</h5></td>\n"
                    + "                <td class=\"try time-border-right time-border-head\"><h5 class=\"heading-align\">Present</h5></td>\n"
                    + "                <td class=\"try  time-border-head\"><h5 class=\"heading-align\">Absent</h5></td>\n"
                    + "            </tr>\n");
            float total = (float) 0.0;
            int count = 0;
            for (int i = 0; i < student_course_list.size(); i++) {
                //System.out.println(student_course_list.get(i));
                String facultyid = sd.getFacultyId(student_course_list.get(i));
                String student_roll = sd.getStudentRoll(email);
                float percentage;

                int[] attendance_details = ga.fetchAttendance(facultyid, student_roll);
                //System.out.println(facultyid);
                out.println("<tr>\n"
                        + "                                   <td class=\"try time-border-right time-border-head\"><h6 class=\"heading-align\">" + student_course_list.get(i) + "</h6></td>\n"
                        + "                                  <td class=\"try time-border-right time-border-head\"><h6 class=\"heading-align\">" + attendance_details[0] + "</h6></td>\n"
                        + "                                  <td class=\"try time-border-right time-border-head\"><h6 class=\"heading-align\">" + attendance_details[1] + "</h6></td>\n"
                        + "                                   <td class=\"try  time-border-head\"><h6 class=\"heading-align\">" + attendance_details[2] + "</h6></td>\n"
                        + "                               </tr>");
                percentage = (float) (((float) attendance_details[1] / (float) attendance_details[0]) * 100.00);
                if (attendance_details[0] != 0) {
                    total += percentage;
                    count += 1;
                    System.out.println(percentage);
                } else {
                    continue;
                }

            }

            System.out.println("total " + total + "count " + count);
            out.println("  </table>\n"
                    + "\n"
                    + "        <h5 style=\"color: red;\">Attendance Percentage : " + String.format("%.2f", total / (float) count) + "%</h5>\n"
                    + "    </center>\n"
                    + "    </bod");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
