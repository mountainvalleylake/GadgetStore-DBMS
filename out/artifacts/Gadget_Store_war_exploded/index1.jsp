<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.List" %>
<%@ page import="Database.*" %><%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 14/12/2016
  Time: 9:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css"/>
<head>
    <title>User Page-Gadget Store</title>
</head>
<body>

<form method="post" action="UserHistory">
    <input type="submit" value="History" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto;">
</form>

<h1>Home-Gadget Store</h1>

<h3>Add New Items</h3>
<p style="margin-left: 10px">Choose among the products below to add.</p>
<%--
<form method="post" action ="WelcomePath">
  Enter BrandName : <input type="text" name="bname">
  <input type="submit" value="enter">
</form>
--%>

<form style="padding-left: 10%" method="post">

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
