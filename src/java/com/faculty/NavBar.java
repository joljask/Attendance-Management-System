
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
                + "<!-- For logout button -->\n" +
"        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\n" +
"        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n" +
"        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>"
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
                    + "                        <button style=\"margin-left: 5px;\" type=\"submit\" class=\"btn btn-primary\" >List Students</button>\n"
                    + "                    </form>\n"
                    + "                </td>\n"
                    + "\n"
                    + "                <td>\n"
                    + "                    <form action=\"MarkPresent\" method=\"post\">\n"
                    + "                        <button style=\"margin-left: 5px;\" type=\"submit\" class=\"btn btn-primary\" \">Mark Present</button>\n"
                    + "                    </form>\n"
                    + "                </td>"
                + "<td>\n" +
"                    <form action=\"FacultyLogout\" method=\"post\">\n" +
"            <button  style=\"margin-left: 5px;\" type=\"submit\" class=\"btn btn-danger \">\n" +
"                <span class=\"glyphicon glyphicon-log-out\"></span> Log out\n" +
"            </button>\n" +
"        </form>\n" +
"                </td>"
                + "</tr>\n"
                    + "\n"
                     + "        </table>\n"
                    + "    </center>";
        
       
            
            return navbar;

            
    }
}
