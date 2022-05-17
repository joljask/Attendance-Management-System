

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

        <!-- external css -->
        <link rel="stylesheet" href="css/styles.css">

        <style>
            h5{
                color:red;
            }
            p{
                color:red;
            }
            h6{
                color:#c42bcf;
            }
        </style>

        <title>Attendance Portal</title>
    </head>
    <body>
        <center>
        <!-- Faculty-->
        <button type="button" class="btn btn-primary" onclick="openPage('addFaculty.jsp')">Add Faculty</button><!-- add faculty -->
        <button type="button" class="btn btn-primary" onclick="openPage('deleteFaculty.jsp')">Delete Faculty</button><!-- delete faculty -->
        <button type="button" class="btn btn-primary" onclick="openPage('editFaculty.jsp')">Edit Faculty</button><!-- edit faculty -->
        
        <!-- Student -->
        <button type="button" class="btn btn-primary" onclick="openPage('addStudent.jsp')">Add Student</button><!-- add student -->
        <button type="button" class="btn btn-primary" onclick="openPage('deleteStudent.jsp')">Delete Student</button><!-- delete student -->
        <button type="button" class="btn btn-primary" onclick="openPage('editStudent.jsp')">Edit Student</button><!-- edit student -->
    </center>

        <!-- main part of edit faculty -->
        <br>
        <br>
    <center>
        <h3>To edit faculty details, enter faculty's Id below.</h3>
    </center>
    <div class="container">
        <form action="EditFaculty" method="post">
            <div class="row height d-flex justify-content-center align-items-center">

                <div class="col-md-8">

                    <div class="search">
                        <i class="fa fa-search"></i>
                        <input type="text" class="form-control" placeholder="Enter Faculty ID to search" name="search_email">
                        <br>
                        <button class="btn btn-primary">Search</button>
                    </div>

                </div>

            </div>
        </form>
    </div>



</body>
</html>
