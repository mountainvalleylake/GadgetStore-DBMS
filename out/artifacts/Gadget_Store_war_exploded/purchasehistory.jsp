<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 16/12/2016
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Purchase History-Gadget Store</title>
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
<p>Here is your purchase history.</p>

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
                /*DBManager dbm = new DBManager();
                Connection connection = dbm.getConnection();

                List<ProPC> ppc = dbm.getProPC();

                request.setAttribute("propc",ppc);*/
            %>
            <c:forEach items="${propc}" var="ppc">

                <tr>
                    <td><c:out value="${ppc.brand}"/></td>
                    <td><c:out value="${ppc.model}"/></td>
                    <td>RAM: <c:out value="${ppc.ram}"/> GB<br>HDD: <c:out value="${ppc.hdd}"/> GB<br>Core: <c:out value="${ppc.core}"/><br>Graphics: <c:out value="${ppc.graphics}"/><br>Warranty: <c:out value="${ppc.warrenty}"/> Years</td>
                    <td><c:out value="${ppc.price}"/></td>
                    <td><form><input type = "number" min="1" max = <c:out value="${ppc.quantity}"/>><input type="hidden" name = "prid" value="${ppc.product_id}"/><input type="submit" value="" style="background-image: url(images/add-to-cart-green1.png); width: 145px; height: 35px"></form></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</div>

</body>
</html>
