<%@ page import="Database.StuffsBought" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 16/12/2016
  Time: 10:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="style.css" rel="stylesheet" type="text/css"/>
<html>
<head>
    <title>Buy Page-Gadget Store</title>
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
<h1>Buy Gadgets</h1>
<p>Confirm your purchase. These are the things that you've chosen: </p>

<div id="table">
    <div class="inner">
        <table>
            <tr>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Final Price</th>
                <th></th>
            </tr>
            <%
                session = request.getSession();
                List<StuffsBought> boughts = (List<StuffsBought>) session.getAttribute("Stuff");

                float total_cost = 0;
                for(int i=0;i<boughts.size();i++) total_cost+=boughts.get(i).getUnitTotal();

                request.setAttribute("stb",boughts);
            %>
            <c:forEach items="${stb}" var="boughts">

                <tr>
                    <td><c:out value="${boughts.name}"/></td>
                    <td><c:out value="${boughts.quantity}"/></td>
                    <td><c:out value="${boughts.price}"/></td>
                    <td><c:out value="${boughts.unitTotal}"/></td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td>Total</td>
                <td><%=total_cost%></td>
            </tr>
        </table>
        <form action="index1.jsp"><input type="submit" name = "buybutton" value = "Buy!" style="font-family: 'Arial Black',sans-serif; font-size: 20px; background-color: aqua; width: auto; height: auto"></form>
    </div>
</div>

</body>
</html>
