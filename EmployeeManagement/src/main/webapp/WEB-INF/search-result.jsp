<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Result</title>
</head>
<body>
<h2>Search Result</h2>
<c:if test="${not empty emp}">
    <p>ID: ${emp.id}</p>
    <p>Name: ${emp.name}</p>
    <p>Contact: ${emp.contactNumber}</p>
    <p>Place: ${emp.place}</p>
<%-- You can add more controls like edit here --%>
</c:if>
<c:if test="${empty emp}">
    <p>No employee found!</p>
</c:if>
<a href="/">Back to list</a>
</body>
</html>