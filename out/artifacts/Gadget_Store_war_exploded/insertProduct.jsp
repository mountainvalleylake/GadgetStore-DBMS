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
    <title>Admin Page-Gadget Store</title>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 100%;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>
</head>
<body>

<form method="post" action="AdminHistory">
    <input type="submit" value="History" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto;">
</form>

<h1>Admin-Gadget Store</h1>

    <h3>Add New Items</h3>
    <p style="margin-left: 10px">Choose among the products below to add.</p>
<%--
<form method="post" action ="WelcomePath">
  Enter BrandName : <input type="text" name="bname">
  <input type="submit" value="enter">
</form>
--%>

<form style="padding-left: 10%" method="post">

    <input type="submit" value = "PC" formaction="pcaddpage.jsp"
           style = "background-image: url(images/computer_pc_PNG7722.png); width: 500px; height: 353px; padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
    <input type ="submit" value="Scanner_Printer" formaction="scanneraddpage.jsp"
           style="background-image: url(images/multifunction_copier_fax_scanner_printer_driver_network_best_color_laser.jpg); width: 500px ; height: 353px; padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
    <input type ="submit" value="Camera" formaction = "cameraaddpage.jsp"
           style="background-image: url(images/camera-0.jpg); width: 500px ; height: 353px;padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
    <input type ="submit" value="Network" formaction="networkaddpage.jsp"
           style="background-image: url(images/router.jpg); width: 500px ; height: 353px;padding-top: 295px; font-family: 'Adobe Hebrew'; font-size: 40px;">
</form>

<pre>


<h3 style="font-size: 20px";>                              Here are the products that you already have in the inventory</h3>
<div id="table1">
    <div class="inner">
        <table>
            <caption><h3><b>PC</b></h3></caption>
            <tr>
                <th>Brand</th>
                <th>Model</th>
                <th>Category</th>
                <th>Warranty</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>RAM</th>
                <th>HDD</th>
                <th>Core</th>
                <th>Graphics</th>
            </tr>
        <%
            DBManager dbm = new DBManager();
            Connection connection = dbm.getConnection();

            List<ProPC> ppc = dbm.getProPC();

            request.setAttribute("propc",ppc);
        %>
        <c:forEach items="${propc}" var="ppc">

        <tr>
            <td><c:out value="${ppc.brand}"/></td>
            <td><c:out value="${ppc.model}"/></td>
            <td><c:out value="${ppc.category}"/></td>
            <td><c:out value="${ppc.warrenty}"/></td>
            <td><c:out value="${ppc.quantity}"/></td>
            <td><c:out value="${ppc.price}"/></td>
            <td><c:out value="${ppc.ram}"/></td>
            <td><c:out value="${ppc.hdd}"/></td>
            <td><c:out value="${ppc.core}"/></td>
            <td><c:out value="${ppc.graphics}"/></td>

            </tr>
        </c:forEach>
        </table>
        </div>
    </div>
    </div>
    <div id="table">
    <div class="inner">
        <table>
            <caption><h3><b>Scanner and Printer</b></h3></caption>
            <tr>
                <th>Brand</th>
                <th>Model</th>
                <th>Category</th>
                <th>Warranty</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Interface</th>
                <th>Resolution</th>
                <th>Speed</th>
                <th>Paper</th>
            </tr>
            <%
                //DBManager dbm = new DBManager();
                connection = dbm.getConnection();

                List<ProScannerPrinter> psp = dbm.getProScanPrint();

                request.setAttribute("prosp",psp);
            %>
            <c:forEach items="${prosp}" var="psp">
            <tr>
            <td><c:out value="${psp.brand}"/></td>
            <td><c:out value="${psp.model}"/></td>
            <td><c:out value="${psp.category}"/></td>
            <td><c:out value="${psp.warrenty}"/></td>
            <td><c:out value="${psp.quantity}"/></td>
            <td><c:out value="${psp.price}"/></td>
            <td><c:out value="${psp.interfaces}"/></td>
            <td><c:out value="${psp.resolution}"/></td>
            <td><c:out value="${psp.speed}"/></td>
            <td><c:out value="${psp.paper}"/></td>
            </tr>

            </c:forEach>
        </table>
    </div>
    </div>
    </div>
    <div id="table2">
    <div class="inner">
        <table>
            <caption><h3><b>Camera</b></h3></caption>
            <tr>
                <th>Brand</th>
                <th>Model</th>
                <th>Category</th>
                <th>Warranty</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Resolution</th>
                <th>Shutter Speed</th>
                <th>Display Type</th>
                <th>Battery</th>
            </tr>
            <%
                //DBManager dbm = new DBManager();
                connection = dbm.getConnection();

                List<ProCamera> pcam = dbm.getProCam();

                request.setAttribute("procam",pcam);
            %>

            <c:forEach items="${procam}" var="pcam">
                <tr>
            <td><c:out value="${pcam.brand}"/></td>
            <td><c:out value="${pcam.model}"/></td>
            <td><c:out value="${pcam.category}"/></td>
            <td><c:out value="${pcam.warrenty}"/></td>
            <td><c:out value="${pcam.quantity}"/></td>
            <td><c:out value="${pcam.price}"/></td>
            <td><c:out value="${pcam.resolution}"/></td>
            <td><c:out value="${pcam.shutterspeed}"/></td>
            <td><c:out value="${pcam.display_type}"/></td>
            <td><c:out value="${pcam.battery}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    </div>
    <div id="table3">
    <div class="inner">
        <table>
            <caption><h3><b>Networks</b></h3></caption>
            <tr>
                <th>Brand</th>
                <th>Model</th>
                <th>Category</th>
                <th>Warranty</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Transfer Rate</th>
                <th>Antenna</th>
                <th>Range</th>
            </tr>
            <%
                //DBManager dbm = new DBManager();
                connection = dbm.getConnection();

                List<ProNetworks> pnet = dbm.getProNet();

                request.setAttribute("pronet",pnet);
            %>
            <c:forEach items="${pronet}" var="pnet">
            <tr>
            <td><c:out value="${pnet.brand}"/></td>
            <td><c:out value="${pnet.model}"/></td>
            <td><c:out value="${pnet.category}"/></td>
            <td><c:out value="${pnet.warrenty}"/></td>
            <td><c:out value="${pnet.quantity}"/></td>
            <td><c:out value="${pnet.price}"/></td>
            <td><c:out value="${pnet.transferrate}"/></td>
            <td><c:out value="${pnet.antena}"/></td>
            <td><c:out value="${pnet.range}"/></td>
            </tr>
            </c:forEach>
        </table>
    </div>
</div>
</pre>
</body>
</html>
