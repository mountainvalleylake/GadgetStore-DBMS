<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="Database.DBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Database.ProNetworks" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 13/12/2016
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Network Gadgets-Gadget Store</title>

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
<h2>Networking Components</h2>
<form method="post" action="Network">
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

                List<ProNetworks> pnet = dbm.getProNet();

                request.setAttribute("pronet",pnet);
            %>
            <c:forEach items="${pronet}" var="pnet">
            <tr>
                <td><c:out value="${pnet.brand}"/></td>
                <td><c:out value="${pnet.model}"/></td>
                <td>Transfer Rate: <c:out value="${pnet.transferrate}"/> bits per second<br>Antena: <c:out value="${pnet.antena}"/><br>Range: <c:out value="${pnet.range}"/>KM</td>
                <td><c:out value="${pnet.price}"/></td>
                <td><form><input type = "number" style="width: 80px" name = "qty" min="0" max = <c:out value="${pnet.quantity}"/>/> <input type = "hidden" name = "prid" value="${pnet.product_id}"/><input formaction="AddToCart" type="submit" value="" style="background-image: url(images/add-to-cart-green1.png); width: 145px; height: 35px"/></form></td>
            </tr>
            </c:forEach>
        </table>
        <form action="fpurchase.jsp" method="post"><input type="submit" name = "finalize" value = "See All Selections" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto"></form>
    </div>
</div>
</form>
</body>
</html>
