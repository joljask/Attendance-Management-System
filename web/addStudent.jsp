
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
        <h3>Form for Student Details</h3>
        <table>

            <form action="AddStudent" method="post" >


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
                    <td><label for="inputAddress">Roll No.</label></td>
                    <td><input type="text" class="form-control" id="inputAddress" placeholder="Roll No" name="f_id"></td>


                </tr>
                <tr>
                    <td colspan="5" style="padding-left: 400px"><h5>Mandatory Subjects</h5></td>
                </tr>

                <tr>
                    <td><input class="form-check-input" type="checkbox" name="aiml" value="AI & ML" id="flexCheckChecked" checked>
                        <label class="form-check-label" for="flexCheckChecked">AI & ML </label>
                    </td>
                    <td>
                        <input class="form-check-input" type="checkbox" name="adm" value="Advance Data Mining" id="flexCheckChecked" checked>
                        <label class="form-check-label" for="flexCheckChecked">Advance Data Mining</label>
                    </td>
                    <td>
                        <input class="form-check-input" type="checkbox" name="wtaj" value="Web Technology - Advance Java" id="flexCheckChecked" checked>
                        <label class="form-check-label" for="flexCheckChecked">Web Technology - Advance Java</label>
                    </td>
                    <td>
                        <input class="form-check-input" type="checkbox" name="coo" value="Computer Oriented Optimization" id="flexCheckChecked" checked>
                        <label class="form-check-label" for="flexCheckChecked">Computer Oriented Optimization</label>
                    </td>
                </tr>

                <tr>
                    <td colspan="5" style="padding-left: 300px"><h5>Optional Subject. Choose one from below.</h5></td>
                </tr>

                <tr>

                    <td></td>
                    <td>


                        <input class="form-check-input" type="radio" name="optional" id="flexRadioDefault1" value="Advanced Operating System">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Advanced Operating System
                        </label>
                    </td>
                    <td>



                        <input class="form-check-input" type="radio" name="optional" id="flexRadioDefault1" value="Cryptography and Network Security">
                        <label class="form-check-label" for="flexRadioDefault1">
                            Cryptography and Network Security
                        </label>
                    </td>
                </tr>

                <tr>

                    <td colspan="4" style="padding-left: 400px">
                        <div class="form-group">
                            <div class="form-check">
                                <input class="form-check-input" type="checkbox" id="gridCheck">
                                <label class="form-check-label" for="gridCheck">
                                    Check if details filled correctly
                                </label>

                                </td>

                                </tr>
                                <tr>
                                    <th colspan="4" style="padding-left: 400px"><button type="submit" class="btn btn-primary">Submit</button></th>
                                </tr>

                                </form>
                                </table>
                                </center>

                                </body>
                                </html>
