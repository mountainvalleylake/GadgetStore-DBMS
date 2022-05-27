<%--
  Created by IntelliJ IDEA.
  User: graphics
  Date: 12/15/2016
  Time: 10:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Your Home-Gadget Store</title>

</head>
<body>
<h1>Welcome To Gadget Store</h1>
<p style="margin-left: 10px">Welcome to the Gadget Store! Choose among the products below.</p>

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
