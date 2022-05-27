<%@ page import="Database.DBManager" %>
<%@ page import="Database.ProCamera" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 13/12/2016
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Camera List-Gadget Store</title>
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
<h2>Camera</h2>
<form  method="post" action="Camera">
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

                    List<ProCamera> pcam = dbm.getProCam();

                    request.setAttribute("procam",pcam);
                %>

            <c:forEach items="${procam}" var="pcam">
            <tr>
                <td><c:out value="${pcam.brand}"/></td>
                <td><c:out value="${pcam.model}"/></td>
                <td>Resolution: <c:out value="${pcam.resolution}"/> MP<br>Battery: <c:out value="${pcam.battery}"/> mAh<br>Display: <c:out value="${pcam.display_type}"/><br>Shutter Speed: <c:out value="${pcam.shutterspeed}"/><br>Warrenty: <c:out value="${pcam.warrenty}"/> Years</td>
                <td><c:out value="${pcam.price}"/></td>
                <td><form method="post"><input type = "number" style="width: 80px" name = "qty" min="0" max = <c:out value="${pcam.quantity}"/>><input type="hidden" name="prid" value="${pcam.product_id}"/><input formaction="AddToCart" type="submit" value="" style="background-image: url(images/add-to-cart-green1.png); width: 145px; height: 35px"></form></td>
            </tr>
            </c:forEach>
        </table>
        <form action="fpurchase.jsp" method="post"><input type="submit" name = "finalize" value = "See All Selections" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: auto; height: auto"></form>
    </div>
</div>
</form>
</body>
</html>
