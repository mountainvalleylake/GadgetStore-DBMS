<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sign Up-Gadget Store</title>
    <style type="text/css">
        label{
            display: inline-block;
            float: left;
            clear: left;
            margin-top: 2%;
            margin-left: 27%;
            width: 250px;
            text-align: right;
        }
        input {
            margin-top: 2%;
            display: inline-block;
            float: left;
        }

    </style>
</head>
<body>
<div style="text-align: center;">
    <h1>Registration</h1>

    <form class = "form" name="registration" method="post" action="SignUp">
        <label>First Name :</label> <input type="text" name="fname"><br/><br/>
        <label>Last Name :</label> <input  type="text" name="lname"><br/><br/>
        <label>User Name :</label> <input  type="text" name="uname"><br/><br/>
        <label>Password :</label> <input  type="password" name="pass"><br/><br/>
        <label>Email ID :</label> <input  type="text" name="email"><br/><br/>
        <label>Address :</label> <input type="text" name="address"><br/><br/>
        <label>Date of Birth :</label> <input type="date" name="dob"><br/><br/>
        <label>&nbsp;</label><input type="submit" value="Sign Up" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: 161px; height: 37px;"/>
    </form>

</div>
</body>
</html>
