<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 14/12/2016
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Add PC Info-Gadget Store</title>
    <style type="text/css">
        label{
            display: inline-block;
            float: left;
            clear: left;
            margin-top: 2%;
            margin-left: 27%;
            width: 250px;
            text-align: right;
        }
        input, select {
            margin-top: 2%;
            display: inline-block;
            float: left;
        }
    </style>
</head>
<body>
<h3>Add PC Info</h3>
<form method="post" action="PCInsert">

<label>Product Name :</label> <select name="pname"><option>PC</option><option>Camera</option><option>Scanner Printer</option><option>Network</option></select><input type="hidden"><br/><br/>
<label>Model No :</label> <input  type="text" name="mno"><br/><br/>
<label>Brand Name :</label> <input  type="text" name="bname"><br/><br/>
<label>Category :</label> <select name="cat"><option>Laptop</option><option>Desktop</option></select><input type="hidden"><br/><br/>
<label>Price :</label> <input  type="text" name="price"><br/><br/>
<label>Warranty :</label> <input type="text" name="war"><br/><br/>
<label>Quantity :</label> <input type="text" name="quant"><br/><br/>
<label>RAM :</label> <input  type="text" name="ram"><br/><br/>
<label>HDD :</label> <input  type="text" name="hdd"><br/><br/>
<label>Core :</label> <input type="text" name="core"><br/><br/>
<label>Graphics :</label> <input type="text" name="graph"><br/><br/>
<label>&nbsp;</label><input type="submit" value="Add" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: 161px; height: 37px;"/>
</form>
</body>
</html>
