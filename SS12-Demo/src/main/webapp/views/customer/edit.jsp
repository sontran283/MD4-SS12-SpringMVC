<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new customer</title>
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f4;
        margin: 0;
        padding: 0;
    }

    h1 {
        color: #333;
    }

    p {
        margin-bottom: 20px;
    }

    a {
        text-decoration: none;
        color: #007bff;
    }

    a:hover {
        text-decoration: underline;
        color: #0056b3;
    }

    form {
        max-width: 400px;
        margin: 20px auto;
        padding: 20px;
        background-color: #fff;
        border: 1px solid #ddd;
        border-radius: 5px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    input[type="text"] {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
        margin-bottom: 10px;
    }

    input[type="submit"] {
        background-color: #4caf50;
        color: #fff;
        padding: 10px 15px;
        border: none;
        border-radius: 3px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #45a049;
    }

    .message {
        color: green;
    }
</style>
<body>
<h1>Create new customer</h1>
<p>
    <a href="/customer/getAll">Back to customer list</a>
</p>
<form method="post" action="/customer/edit">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="hidden" name="customerId" id="customerId" value="${customer.customerId}" readonly></td>
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