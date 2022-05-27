<%@ page import="Database.DBManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="Database.UserHistory" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: graphics
  Date: 12/20/2016
  Time: 1:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Your Purchases</title>
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
<div id="table">
    <div class="inner">
        <table>
            <tr>
                <th>Name</th>
                <th>Brand</th>
                <th>Model</th>
                <th>Category</th>
                <th>Payment Type</th>
                <th>Shipping Address</th>
                <th>Purchase Date</th>
                <th>Unit Cost</th>
                <th>Quantity</th>
                <th>Final Cost</th>
            </tr>
            <%
                session = request.getSession();
                DBManager dbm = new DBManager();
                Connection connection = dbm.getConnection();
                int user_id = (int) session.getAttribute("User_ID");
                 List<UserHistory> uhis;
                uhis = dbm.getUserHistory(user_id);

                request.setAttribute("uhst",uhis);
            %>
            <c:forEach items="${uhst}" var="uhis">

                <tr>
                    <td><c:out value="${uhis.name}"/></td>
                    <td><c:out value="${uhis.brand}"/></td>
                    <td><c:out value="${uhis.model}"/></td>
                    <td><c:out value="${uhis.cat}"/></td>
                    <td><c:out value="${uhis.ptype}"/></td>
                    <td><c:out value="${uhis.saddr}"/></td>
                    <td><c:out value="${uhis.dates}"/></td>
                    <td><c:out value="${uhis.upr}"/></td>
                    <td><c:out value="${uhis.quant}"/></td>
                    <td><c:out value="${uhis.fpr}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>
</body>
</html>
