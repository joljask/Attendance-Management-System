package com.faculty;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MarkPresent", urlPatterns = {"/MarkPresent"})
public class MarkPresent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        try {
            /* TODO output your page here. You may use following sample code. */
            NavBar nav = new NavBar();
            out.println(nav.getNavbar());

            String email = (String) session.getAttribute("email");
            System.out.println(email);
            out.println("<br><br><center><h4 style=\"color:red;\">User : " + email + "</h4></center>");

            // Navbar and display email code ends here
            //Display all the sudents with respective to subject and include radio buttons
            // JDBC connection fetching course from faculty table
            GetFacultyCourse fetch_faculty_course = new GetFacultyCourse();
            String[] faculty_course = fetch_faculty_course.getFacultyCourse(email);
            System.out.println(faculty_course[0] + " : facultyid"); //working
            System.out.println(faculty_course[1] + " : faculty course");//working

            //To get student roll no and full name 
            String url = "jdbc:mysql://localhost:3306/attendance";
            String username = "root";
            String password = "admin@1234";

            try {
                ListStudentSql lsq = new ListStudentSql();

                System.out.println("lsq " + faculty_course[1] + " List Student Sql");
                String selected_course = lsq.selectCourse(faculty_course[1]);
                //incomplete sql statement where add it using switch case
                String sql = "select roll, email, firstname, lastname from student where " + selected_course + " = ?  order by roll";

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(sql);

                st.setString(1, faculty_course[1]);

                ResultSet rs = st.executeQuery();

                System.out.println("List of students form ListStudents.java\n");

                //table heading for listing students
                out.println("<br>\n"
                        + "    <center>\n"
                        + "        <table class=\"mark-table \">\n"
                        + "            <form action=\"AddAttendanceSql \" method=\"post\">\n"
                        + "                <tr>\n"
                        + "                    <th class=\"mark-th ,mark-td \">Roll No.</th>\n"
                        + "                    <th class=\"mark-th ,mark-td \">Email </th>\n"
                        + "                    <th class=\"mark-th ,mark-td \">Name</th>\n"
                        + "                    <th class=\"mark-th ,mark-td \">Present</th>\n"
                        + "                </tr>");

                //arraylist to store student details and send to another servlet for attendance
                ArrayList<String> rolls = new ArrayList<String>();
                ArrayList<String> emails = new ArrayList<String>();
                ArrayList<String> first_name = new ArrayList<String>();
                ArrayList<String> last_name = new ArrayList<String>();

                while (rs.next()) 
                {

                    System.out.println("roll - " + rs.getString("roll") + " Email : " + rs.getString("email"));

                    rolls.add(rs.getString("roll"));
                    emails.add(rs.getString("email"));
                    first_name.add(rs.getString("firstname"));
                    last_name.add(rs.getString("lastname"));

                    // table data design
                    // change td even in mark.css
                    // change in query order by asc in this java page
                    // use array list to store data
                    out.println("<tr class=\"mark-tr\">\n"
                            + "            <td class=\"mark-td\">" + rs.getString("roll") + " <input type=\"hidden\" name=\"rolls\" value=\" "+rs.getString("roll") +"\">  </td>\n"
                            + "            <td class=\"mark-td\">" + rs.getString("email") + "</td>\n"
                            + "            <td class=\"mark-td\">" + rs.getString("firstname") + " " + rs.getString("lastname") + "</td>\n"
                            + "            <td class=\"mark-td\" >"
                            + "                 <div class=\"form-check\">\n"
                            + "                     <input  class=\"form-check-input\" type=\"checkbox\" value=\""+rs.getString("roll") +"\" name=\"att\" id=\"flexCheckDefault\"> \n"
                            + "                 </div>"
                            + "            </td>\n" // add check box

                            + " </tr>");

                }

                out.println("<tr>\n"
                        + "                    <td colspan=\"4\">\n"
                        + "                        <button style=\"margin-left: 40%; margin-top:15px\" type=\"button \" class=\"btn btn-success btn-lg btn-block \">\n"
                        + "                            Submit Attendance\n"
                        + "                        </button>\n"
                        + "                    </td>\n"
                        + "                </tr>\n"
                        + "            </form>\n"
                        + "        </table>\n"
                        + "    </center>");

                //out.println("<br><button type=\"button\" class=\"btn btn-success btn-lg btn-block\">Submit Attendance</button>");
                //System.out.println("Outside while loop");
                //for (String i : rolls) 
                //System.out.println("Size of rolls in MarkPresent  : " + rolls.size());
                //request.setAttribute("send_roll", rolls);
                
                //RequestDispatcher rd = request.getRequestDispatcher("/AddAttendanceSql"); //add servlet url pattern
                //rd.forward(request, response);
            } catch (Exception e) {
                System.out.println(e);
            }

            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
