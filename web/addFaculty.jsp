

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
        
        <style>
            td{
                padding:20px;
            }
        </style>

        <title>Attendance Portal</title>
    </head>
    <body>
        <!-- Faculty-->
        <button type="button" class="btn btn-primary" onclick="openPage('addFaculty.jsp')">Add Faculty</button><!-- add faculty -->
        <button type="button" class="btn btn-primary">Delete Faculty</button><!-- delete faculty -->
        <button type="button" class="btn btn-primary">Edit Faculty</button><!-- edit faculty -->

        <!-- Student -->
        <button type="button" class="btn btn-primary">Add Student</button><!-- add student -->
        <button type="button" class="btn btn-primary">Delete Student</button><!-- delete student -->
        <button type="button" class="btn btn-primary">Edit Student</button><!-- edit student -->
        <br>
        <br>
        <br>
        <br>
        

    <center>
        <table>

            <form action="AddFaculty" method="post" >


                <tr>
                    <td><label for="inputAddress">First Name</label></td>
                    <td>      <input type="text" class="form-control" placeholder="First name" name="f_first_name"> </td>
                    <td><label for="inputAddress">Last Name</label></td>
                    <td><input type="text" class="form-control" placeholder="Last name" name="f_last_name">  </td>
                </tr>




                <tr>
                    <td><label for="inputEmail4">Email</label></td>
                    <td> <input type="email" class="form-control" id="inputEmail4" placeholder="Email" name="f_email"> </td>

                    <td><label for="inputAddress">Mobile No.</label></td>
                    <td><input type="text" class="form-control" placeholder="Mobile Number" name="f_mobile"></td>
                </tr>



                <tr>
                    <td><label for="inputAddress">Faculty ID</label></td>
                    <td><input type="text" class="form-control" id="inputAddress" placeholder="Faculty ID" name="f_id"></td>

                    <td> <label for="inputState">Select Course</label></td> 
                    <td>
                        <select id="inputState" class="form-control" name = f_course>
                            <option selected>Choose</option>
                            <option>AI & ML</option> 
                            <option>Advance Data Mining</option>
                            <option>Advanced Operating System</option>
                            <option>Cryptography and Network Security</option>
                            <option>Web Technology - Advance Java</option>
                            <option>Computer Oriented Optimization</option>

                        </select>
                    </td>
                </tr>

                <tr>
                    
                    <td colspan="4" style="padding-left: 200px">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="gridCheck">
                                <label class="form-check-label" for="gridCheck">
                                    Check if details filled correctly
                                </label>
 
                    </td>
                    
                </tr>
                <tr>
                    <th colspan="4" style="padding-left: 200px"><button type="submit" class="btn btn-primary">Submit</button></th>
                </tr>

            </form>
        </table>
    </center>
</body>
</html>
