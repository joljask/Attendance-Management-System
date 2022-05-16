
package com.faculty;

import java.io.PrintWriter;


public class NavBar
{
    public String getNavbar()
    {
        String navbar = "<!DOCTYPE html>"
                + "<html><head>"
                + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                    + "        \n"
                    + "        <!-- Bootstrap CSS -->\n"
                    + "  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\"\n"
                    + "    integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
                    + "<link rel=\"stylesheet\" href=\"css/mark.css\">\n"
                    + "  <!-- Javascript -->\n"
                    + "  <script src=\"js/admin.js\"></script><!-- comment -->\n"
                    + "  \n"
                    + "        <title>Attendance Portal</title>"
                + "</head>"
                + "<body>"
                + "<center>\n"
                    + "        <table>\n"
                    + "            <tr>\n"
                    + "                <td>\n"
                    + "                    <form action=\"ListStudent\" method=\"post\">\n"
                    + "\n"
                    + "                        <button type=\"submit\" class=\"btn btn-primary\" >List Students</button>\n"
                    + "                    </form>\n"
                    + "                </td>\n"
                    + "\n"
                    + "                <td>\n"
                    + "                    <form action=\"MarkPresent\" method=\"post\">\n"
                    + "                        <button type=\"submit\" class=\"btn btn-primary\" \">Mark Present</button>\n"
                    + "                    </form>\n"
                    + "                </td>\n"
                    + "\n"
              /*      + "                <td>\n"
                    + "                    <form action=\"addStudent.jsp\" method=\"post\">\n"
                    + "                        <button type=\"submit\" class=\"btn btn-primary\" >Add Student</button>\n"
                    + "                    </form>\n"
                    + "                </td>\n"
                    + "\n"
                    + "                <td>\n"
                    + "                    <form action=\"\" method=\"post\">\n"
                    + "                        <button type=\"submit\" class=\"btn btn-primary\" onclick=\"openPage('')\">Add Student</button>\n"
                    + "                    </form>\n"
                    + "                </td>\n"
                    + "\n"
                    + "                <td>\n"
                    + "                    <form action=\"\" method=\"post\">\n"
                    + "                        <button type=\"submit\" class=\"btn btn-primary\" onclick=\"openPage('')\">Delete Student</button>\n"
                    + "                    </form>\n"
                    + "                </td>\n"
                    + "\n"
                    + "                <td>\n"
                    + "                    <form action=\"\" method=\"post\">\n"
                    + "                        <button type=\"submit\" class=\"btn btn-primary\" onclick=\"openPage('')\">Edit Student</button>\n"
                    + "                    </form> \n"
                    + "                </td>\n"
                    + "            </tr>\n"
             */       + "        </table>\n"
                    + "    </center>";
        
       
            
            return navbar;

            
    }
}
