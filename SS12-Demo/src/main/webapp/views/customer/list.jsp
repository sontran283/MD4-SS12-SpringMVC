<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<style>
    table {
        width: 100%;
        border-collapse: collapse;
        margin-bottom: 20px;
    }

    table, th, td {
        border: 1px solid #ddd;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f2f2f2;
    }

    a {
        text-decoration: none;
        color: #007bff;
    }

    a:hover {
        text-decoration: underline;
        color: #0056b3;
    }

</style>
<body>
<h1>Customers</h1>
<p>
    <a href="<%=request.getContextPath()%>/customer/create">Create new customer</a>
</p>
<table border="1">
    <tr>
        <td>STT</td>
        <td>Name</td>
        <td>Address</td>
        <td>Email</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach items='${customerList}' var="customer" varStatus="loop">
        <tr>
            <td>${loop.index+1}</td>
            <td>${customer.getCustomerName()}</td>
            <td>${customer.getAddress()}</td>
            <td>${customer.getEmail()}</td>
            <td><a href="/customer/edit?id=${customer.getCustomerId()}">edit</a></td>
            <td><a href="/customer/delete?id=${customer.getCustomerId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>