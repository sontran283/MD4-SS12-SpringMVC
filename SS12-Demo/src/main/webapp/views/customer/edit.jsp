<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new customer</h1>
<p>
    <a href="/customer/getAll">Back to customer list</a>
</p>
<form method="post" action="/customer/edit">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="customerId" id="customerId" value="${customer.customerId}" readonly disabled></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="customerName" id="customerName" value="${customer.customerName}"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" id="address" value="${customer.address}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" id="email" value="${customer.email}"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Edit customer"></td>
        </tr>
    </table>
</form>
</body>
</html>