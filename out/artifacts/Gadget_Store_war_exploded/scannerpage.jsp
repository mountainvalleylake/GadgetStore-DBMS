<%@ page import="Database.DBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Database.ProScannerPrinter" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 13/12/2016
  Time: 4:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Scanner and Printer List-Gadget Store</title>

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
<h2>Scanner and Printer</h2>
<form method="post" action="ScannerPrinter">
<div id="table">
    <div class="inner">
        <table>
            <tr>

                <th>Brand</th>
                <th>Model</th>
                <th>Description</th>
                <th>Price</th>
                <th></th>
            </tr>
            <%
                DBManager dbm = new DBManager();
                Connection connection = dbm.getConnection();

                List<ProScannerPrinter> psp = dbm.getProScanPrint();

                request.setAttribute("prosp",psp);
            %>
            <c:forEach items="${prosp}" var="psp">
            <tr>
                <td><c:out value="${psp.brand}"/></td>
                <td><c:out value="${psp.model}"/></td>
                <td>Interface: <c:out value="${psp.interfaces}"/><br>Resolution: <c:out value="${psp.resolution}"/><br>Speed: <c:out value="${psp.speed}"/><br>Paper: <c:out value="${psp.paper}"/><br>Warranty: <c:out value="${psp.warrenty}"/> Years</td>
                <td><c:out value="${psp.price}"/></td>
                <td><form method="post"><input type = "number" style="width: 80px" name = "qty" min="0" max = <c:out value="${psp.quantity}"/>><input type="hidden" name = "prid" value="${psp.product_id}"/><input formaction="AddToCart" type="submit" value="" style="background-image: url(images/add-to-cart-green1.png); width: 145px; height: 35px"></form></td>
            </tr>
            </c:forEach>
        </table>
        <form action="fpurchase.jsp" method="post"><input type="submit" name = "finalize" value = "See All Selections" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto"></form>
    </div>
</div>
</div>
</form>
</body>
</html>
