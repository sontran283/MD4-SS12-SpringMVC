<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/30/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Student</title>
</head>
<style>
    /* Reset some default styles */
    body, h2, form {
        margin: 0;
        padding: 0;
    }

    body {
        font-family: 'Arial', sans-serif;
        background-color: #f4f4f4;
    }

    h2 {
        color: #333;
        text-align: center;
        margin-top: 20px;
    }

    form {
        max-width: 400px;
        margin: 20px auto;
        background: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    label {
        display: block;
        margin-bottom: 8px;
        color: #333;
    }

    input {
        width: 100%;
        padding: 8px;
        margin-bottom: 16px;
        box-sizing: border-box;
    }

    button {
        background: #007bff;
        color: #fff;
        border: none;
        padding: 10px 15px;
        border-radius: 4px;
        cursor: pointer;
    }

    button:hover {
        background: #0056b3;
    }

    /* Style for the checkbox */
    #sex {
        margin-top: 8px;
    }

    a {
        display: block;
        text-align: center;
        color: #007bff;
        text-decoration: none;
        margin-top: 10px;
    }

</style>
<body>
<div class="container">
    <h2>Add Student</h2>
    <form method="post" action="<c:url value='/student/save' />">
        <label for="studentName">Name:</label>
        <input type="text" id="studentName" name="studentName" required><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br>

        <label for="sex">Sex:</label>
        <input type="checkbox" id="sex" name="sex">

        <button type="submit">Add Student</button>
    </form>
    <a href="<c:url value='/student/student' />">Back to Students</a>
</div>

</body>
</html>

