<%--
  Created by IntelliJ IDEA.
  User: Ahmed
  Date: 14/12/2016
  Time: 11:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="style.css" rel="stylesheet" type="text/css" />
<head>
    <title>Add Scanner and Printer Info-Gadget Store</title>
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
<h3>Add Scanner Printer Info</h3>
<form  method="post" action="ScannerPrinterInsert">

<label>Product Name :</label> <select name="pname"><option>PC</option><option>Camera</option><option>Scanner Printer</option><option>Network</option></select><input type="hidden"><br/><br/>
<label>Model No :</label> <input  type="text" name="mno"><br/><br/>
<label>Brand Name :</label> <input  type="text" name="bname"><br/><br/>
<label>Category :</label> <select name="cat"><option>Scanner</option><option>Printer</option></select><input type="hidden"><br/><br/>
<label>Price :</label> <input  type="text" name="price"><br/><br/>
<label>Warranty :</label> <input type="text" name="war"><br/><br/>
<label>Quantity :</label> <input type="text" name="quant"><br/><br/>
<label>Interface :</label> <input  type="text" name="intef"><br/><br/>
<label>Resolution :</label> <input  type="text" name="resl"><br/><br/>
<label>Speed :</label> <input type="text" name="speed"><br/><br/>
<label>Paper :</label> <input type="text" name="pap"><br/><br/>
<label>&nbsp;</label><input type="submit" value="Add" style="font-family: 'Arial Black',sans-serif; font-size: 16px; background-color: aqua; width: 161px; height: 37px;"/>
</form>
</body>
</html>
