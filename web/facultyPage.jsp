

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
        
        

        <title>Attendance Portal</title>
    </head>
    <body>
    <center>
        <table>
            <tr>
                <td>
                    <form action="ListStudent" method="post">

                        <button type="submit" class="btn btn-primary" >List Students</button>
                    </form>
                </td>

                <td>
                    <form action="MarkPresent" method="post">
                        <button type="submit" class="btn btn-primary" >Mark Present</button>
                    </form>
                </td>

                <td>
                    <form action="addStudent.jsp" method="post">
                        <button type="submit" class="btn btn-primary" >Add Student</button>
                    </form>
                </td>

                <td>
                    <form action="" method="post">
                        <button type="submit" class="btn btn-primary" onclick="openPage('')">Add Student</button>
                    </form>
                </td>

                <td>
                    <form action="" method="post">
                        <button type="submit" class="btn btn-primary" onclick="openPage('')">Delete Student</button>
                    </form>
                </td>

                <td>
                    <form action="" method="post">
                        <button type="submit" class="btn btn-primary" onclick="openPage('')">Edit Student</button>
                    </form> 
                </td>
            </tr>
        </table>
    </center>


    <%

        String email = (String) session.getAttribute("email");
        //System.out.println(email);
        out.println("<br><center><h4 style=\"color:red;\">User : " + email + "</h4></center>");
    %>
</body>
</html>
