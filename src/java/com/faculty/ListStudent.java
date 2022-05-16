package com.faculty;

import com.test.dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ListStudent", urlPatterns = {"/ListStudent"})
public class ListStudent extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        try {

            NavBar nav  = new NavBar();
            out.println(nav.getNavbar());

            String email = (String) session.getAttribute("email");
            System.out.println(email);
            out.println("<br><br><center><h4 style=\"color:red;\">User : " + email + "</h4></center>");

            // Navbar and display email code ends here
            //Display list of students in particular subject
            // JDBC connection fetching course from faculty table
            GetFacultyCourse fetch_faculty_course = new GetFacultyCourse();
            String[] faculty_course = fetch_faculty_course.getFacultyCourse(email);
            System.out.println(faculty_course[0] + " : facultyid"); //working
            System.out.println(faculty_course[1] + " : faculty course");//working

            //To get student and their attendance
            String url = "jdbc:mysql://localhost:3306/attendance";
            String username = "root";
            String password = "admin@1234";
            try {
                ListStudentSql lsq = new ListStudentSql();

                System.out.println("lsq " + faculty_course[1] + " List Student Sql");
                String selected_course = lsq.selectCourse(faculty_course[1]);
                //incomplete sql statement where add it using switch case
                String sql = "select roll, email, firstname, lastname from student where " + selected_course + " = ?";

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement st = con.prepareStatement(sql);

                st.setString(1, faculty_course[1]);

                ResultSet rs = st.executeQuery();
                System.out.println("List of students form ListStudents.java\n");

                //Class GetAttendance
                GetAttendance ga = new GetAttendance();

                //table heading for listing students
                out.println("<br><center><table>\n"
                        + "        <tr>\n"
                        + "            <th style=\"border: 2px solid black; text-align: center; padding: 10px;\">Roll No.</th>\n"
                        + "            <th style=\"border: 2px solid black; text-align: center; padding: 10px;\">Email </th>\n"
                        + "            <th style=\"border: 2px solid black; text-align: center; padding: 10px;\">Name</th>\n"
                        + "            <th style=\"border: 2px solid black; text-align: center; padding: 10px;\">Total Class</th>\n"
                        + "            <th style=\"border: 2px solid black; text-align: center; padding: 10px;\">Present</th>\n"
                        + "            <th style=\"border: 2px solid black; text-align: center; padding: 10px;\">Absent</th>\n"
                        + "            <th style=\"border: 2px solid black; text-align: center; padding: 10px;\">Percentage</th>\n"
                        + "        </tr>");

                while (rs.next()) {
                    int[] attendance_count = ga.fetchAttendance(faculty_course[0], rs.getString("roll"));
                    System.out.println(" Roll no - " + rs.getString("roll") + "\nEmail id : " + rs.getString("email") + "\nFirst Name : " + rs.getString("firstname") + "\nLast Name : " + rs.getString("lastname") + "\nClasses conducted : " + attendance_count[0] + "  Total Present : " + attendance_count[1] + "  Total absent : " + attendance_count[2]);

                    //Code to design table for list student page where it ll display the above statement
                    out.println("<tr>\n"
                            + "            <td style=\"border: 1px solid black; text-align: center; padding: 10px;\">" + rs.getString("roll") + "</td>\n"
                            + "            <td style=\"border: 1px solid black; text-align: center; padding: 10px;\">" + rs.getString("email") + "</td>\n"
                            + "            <td style=\"border: 1px solid black; text-align: center; padding: 10px;\">" + rs.getString("firstname") + " "+ rs.getString("lastname") +"</td>\n"
                            + "            <td style=\"border: 1px solid black; text-align: center; padding: 10px;\">" + attendance_count[0] + "</td>\n"
                            + "            <td style=\"border: 1px solid black; text-align: center; padding: 10px;\">" + attendance_count[1] + "</td>\n"
                            + "            <td style=\"border: 1px solid black; text-align: center; padding: 10px;\">" + attendance_count[2] + "</td>\n"
                            + "            <td style=\"border: 1px solid black; text-align: center; padding: 10px;\">" + calculatePercentage(attendance_count[0],attendance_count[1]) + "</td>\n"
                            + "        </tr>");

                }
                out.println("</table></center>");

            } catch (Exception ex) {
                Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            //List Student with there attendance in the subject
            //ListStudentSql lsq = new ListStudentSql();
            //String[] student_list = lsq.getList(faculty_course);
            //System.out.println("list of students");
            //for(int i=0;i<student_list.length;i++)
            //{
            //    System.out.println(student_list[i]);
            //}
            //String sql_student = "SELECT  * from student WHERE course"+/*change course*/ " = ?";
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private String calculatePercentage(int total, int total_present) {
        
        float percentage = (float) ((float)(total_present/(float)total)*100.00);
        String paragraph;
        
        if(percentage >= 75)
        {
            return "<h6>"+String.format("%.2f", percentage)+"</h6>";
        }
        else
        {
            return "<h6 style=\"color:red;\">"+String.format("%.2f", percentage)+"</h6>";
        }
        
        
        
    }

}
