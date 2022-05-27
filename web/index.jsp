<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 12/12/2016
  Time: 9:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
  <title>Gadget Store</title>

</head>
<body>

<form class="login" method="post">
    <input type="submit" value="Login" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto;" formaction="UserLogin.jsp">
</form>

<form class="login" method="post">
    <input type="submit"  value="Admin Login" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto;" formaction="adminlogin.jsp">
</form>

<form class="signup" method="post">
<input type="submit" value="SignUp" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto;" formaction="UserSignUp.jsp">
</form>

<h1>Welcome To Gadget Store</h1>
<p style="margin-left: 10px">Welcome to the Gadget Store! Choose among the products below.</p>
<%--
<form method="post" action ="WelcomePath">
  Enter BrandName : <input type="text" name="bname">
  <input type="submit" value="enter">
</form>
--%>

    <form style="padding-left: 10%" method="post" action="WelcomePath">

    <input type="submit" value = "PC" formaction="pcpage.jsp"
             style = "background-image: url(images/computer_pc_PNG7722.png); width: 500px; height: 353px; padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
    <input type ="submit" value="Scanner_Printer" formaction="scannerpage.jsp"
            style="background-image: url(images/multifunction_copier_fax_scanner_printer_driver_network_best_color_laser.jpg); width: 500px ; height: 353px; padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
    <input type ="submit" value="Camera" formaction = "camerapage.jsp"
           style="background-image: url(images/camera-0.jpg); width: 500px ; height: 353px;padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
    <input type ="submit" value="Network" formaction="networkpage.jsp"
           style="background-image: url(images/router.jpg); width: 500px ; height: 353px;padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
</form>
</body>
</html>
