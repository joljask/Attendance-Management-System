

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- Javascript -->
        <script src="js/admin.js"></script>

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
            if (session.getAttribute("emailID") == null) {
                response.sendRedirect("admin.jsp");
            }

        %>
    <center>
        <table>
            <tr>
                <td>
                    <!-- Faculty-->
                    <button style="margin-left: 5px;" type="button" class="btn btn-primary" onclick="openPage('addFaculty.jsp')">Add Faculty</button><!-- add faculty -->
                </td>
                <td>
                    <button style="margin-left: 5px;" type="button" class="btn btn-primary" onclick="openPage('deleteFaculty.jsp')">Delete Faculty</button><!-- delete faculty -->
                </td>
                <td>
                    <button style="margin-left: 5px;" type="button" class="btn btn-primary" onclick="openPage('editFaculty.jsp')">Edit Faculty</button><!-- edit faculty -->
                </td>
                <td>
                    <!-- Student -->
                    <button style="margin-left: 5px;" type="button" class="btn btn-primary" onclick="openPage('addStudent.jsp')">Add Student</button><!-- add student -->
                </td>
                <td>
                    <button style="margin-left: 5px;" type="button" class="btn btn-primary" onclick="openPage('deleteStudent.jsp')">Delete Student</button><!-- delete student -->
                </td>
                <td>
                    <button style="margin-left: 5px;" type="button" class="btn btn-primary" onclick="openPage('editStudent.jsp')">Edit Student</button><!-- edit student -->
                </td>
                <td>
                    <form action="AdminLogout" method="post">
                        <button style="margin-left: 5px;" type="submit" class="btn btn-danger ">
                            <span class="glyphicon glyphicon-log-out"></span> Log out
                        </button>
                    </form>
                </td>
            </tr>
        </table>









    </center>   
</body>

<script type="text/javascript">

</script>
</html>
