<%-- 
    Document   : student.jsp
    Created on : Apr 30, 2022, 8:54:12 PM
    Author     : jolly
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

        <!-- External CSS-->
        <link rel="stylesheet" href="css/styles.css">
        <title>Attendance Portal</title>
    </head>
    <body class="bg-info">
        <!-- Navigation Bar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary ">
            <div class="container-fluid">
                <a class="navbar-brand text-dark" href="#">Attendance Portal</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link " aria-current="page" href="index.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="admin.jsp">Admin</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link " href="faculty.jsp">Faculty</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active " href="#" tabindex="-1">Student</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <br>

        <!-- Logo and title-->
        <div class="container bg-info">
            <div class="row">

                <div class="col-1 ">
                    <img src="images/nitLOGO.png" alt="NIT Raipur Logo" height="100">
                </div>

                <div class="col-5 offset-1">
                    <h1 class="page-title">Attendance Management System</h1>
                </div>
            </div>
        </div>
        <br>
        <br>

        <!-- Student login form-->
        <div class="container-fluid container-login">

            <div class="row">
                <div class="col-3  login-head">
                    <h1>STUDENT LOGIN</h1> 

                </div>


                <div class="col-4 offset-2  form-outer-pad">
                    <form>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Email address</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
                                   placeholder="Enter email">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Check me out</label>
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>

            </div>

        </div>


        <!-- Optional JavaScript; choose one of the two! -->

        <!-- Option 1: Bootstrap Bundle with Popper -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

        <!-- Option 2: Separate Popper and Bootstrap JS -->
        <!--
          <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
        -->


    </body>
</html>
