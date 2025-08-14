<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h2>All Employees</h2>
<a href="add">Add New Employee</a>
<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Contact</th><th>Place</th><th>Actions</th>
    </tr>
    <c:forEach var="emp" items="${employees}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.contactNumber}</td>
            <td>${emp.place}</td>
            <td>
                <a href="delete?id=${emp.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<form action="search" method="get">
    <input type="number" name="id" placeholder="Search by ID" required>
    <input type="submit" value="Search">
</form>
</body>
</html>