<%@ page import="Database.DBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Database.PurchaseHistory" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 19/12/2016
  Time: 10:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Administrator History-Gadget Store</title>
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
<h1>Purchase History</h1>

<p>Check transaction between dates: </p>
<div id="table">
    <div class="inner">
        <table>
            <tr>
                <th>Serial No</th>
                <th>Customer ID</th>
                <th>User Name</th>
                <th>Email</th>
                <th>Payment Type</th>
                <th>Shipping Address</th>
                <th>Purchase Date</th>
                <th>Product ID</th>
                <th>Name</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Category</th>
                <th>Quantity</th>
                <th>Unit Cost</th>
                <th>Final Cost</th>
            </tr>
            <%
                DBManager dbm = new DBManager();
                Connection connection = dbm.getConnection();

                List<PurchaseHistory> his = dbm.getHistory();

                request.setAttribute("hstry",his);
            %>
            <c:forEach items="${hstry}" var="his">

                <tr>
                    <td><c:out value="${his.slno}"/></td>
                    <td><c:out value="${his.cid}"/></td>
                    <td><c:out value="${his.uname}"/></td>
                    <td><c:out value="${his.mail}"/></td>
                    <td><c:out value="${his.ptype}"/></td>
                    <td><c:out value="${his.saddr}"/></td>
                    <td><c:out value="${his.dates}"/></td>
                    <td><c:out value="${his.pid}"/></td>
                    <td><c:out value="${his.name}"/></td>
                    <td><c:out value="${his.brand}"/></td>
                    <td><c:out value="${his.model}"/></td>
                    <td><c:out value="${his.cat}"/></td>
                    <td><c:out value="${his.quant}"/></td>
                    <td><c:out value="${his.upr}"/></td>
                    <td><c:out value="${his.fpr}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>
