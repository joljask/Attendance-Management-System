

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ page import="javax.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- Javascript -->
        <script src="js/admin.js"></script><!-- comment -->
        
        <!-- For logout button -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        
        

        <title>Attendance Portal</title>
    </head>
    <body>
        
        <%
            response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");

            response.setHeader("Pragma", "no-cache");
            response.setHeader("Expires", "0");
        %>

        <%
            if (session.getAttribute("email") == null) {
                response.sendRedirect("faculty.jsp");
            }

        %>
        
    <center>
        <table>
            <tr>
                <td>
                    <form action="ListStudent" method="post">

                        <button style="margin-left: 5px;" type="submit" class="btn btn-primary" >List Students</button>
                    </form>
                </td>

                <td>
                    <form action="MarkPresent" method="post">
                        <button  style="margin-left: 5px;" type="submit" class="btn btn-primary" >Mark Present</button>
                    </form>
                </td>
                <td>
                    <form action="FacultyLogout" method="post">
            <button  style="margin-left: 5px;" type="submit" class="btn btn-danger ">
                <span class="glyphicon glyphicon-log-out"></span> Log out
            </button>
        </form>
                </td>

                
        </table>
    </center>


    <%

        String email = (String) session.getAttribute("email");
        //System.out.println(email);
        out.println("<br><center><h4 style=\"color:red;\">User : " + email + "</h4></center>");
    %>
</body>
</html>
