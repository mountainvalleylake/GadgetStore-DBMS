<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="style.css" rel="stylesheet" type="text/css"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page-Gadget Store</title>
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
<div style="text-align: center">
<form method="post" action="Login">
    <label>Enter Username :</label> <input type="text" name="uname"><br>
    <label>Email :</label> <input type="text" name="email"><br>
    <label>Enter Password :</label> <input type="password" name="pass"><br>
    <label>&nbsp;</label><input type="submit" value="Sign In" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: 161px; height: 37px;"/>

</form>
</div>
</body>
</html>

