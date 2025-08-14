<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
</head>
<body>
<h2>Add New Employee</h2>
<form action="save" method="post">
    Name: <input type="text" name="name" required><br>
    Contact Number: <input type="text" name="contactNumber" required><br>
    Place: <input type="text" name="place" required><br>
    <input type="submit" value="Save">
</form>
</body>