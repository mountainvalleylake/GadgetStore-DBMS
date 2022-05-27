<%@ page import="Database.DBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Database.ProPC" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 13/12/2016
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>PC List-Gadget Store</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 80%;
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
<h2>PC and Laptops</h2>
<form method="post" action="PC">
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

            List<ProPC> ppc = dbm.getProPC();

            request.setAttribute("propc",ppc);
        %>
        <c:forEach items="${propc}" var="ppc">

        <tr>
            <td><c:out value="${ppc.brand}"/></td>
            <td><c:out value="${ppc.model}"/></td>
            <td>RAM: <c:out value="${ppc.ram}"/> GB<br>HDD: <c:out value="${ppc.hdd}"/> GB<br>Core: <c:out value="${ppc.core}"/><br>Graphics: <c:out value="${ppc.graphics}"/><br>Warranty: <c:out value="${ppc.warrenty}"/> Years</td>
            <td><c:out value="${ppc.price}"/></td>
            <td><form method="post"><input type = "number" style="width: 80px" name = "qty" min="0" max = <c:out value="${ppc.quantity}"/>><input type="hidden" name = "prid" value="${ppc.product_id}"/><input formaction="AddToCart" type="submit" value="" style="background-image: url(images/add-to-cart-green1.png); width: 145px; height: 35px"></form></td>
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
