<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Management Application</title>
</head>
<body>
<center>
    <h1>LIBRARY</h1>
    <p><a href="/home">List</a></p>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List card</h2></caption>
        <tr>
            <th>ID</th>
            <th>Book Name</th>
            <th>Student Name</th>
            <th>Ngày mượn</th>
            <th>Ngày trả</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="B" items="${list}">
            <tr>
                <td><c:out value="${B.id}"/></td>
                <td><c:out value="${B.book.name}"/></td>
                <td><c:out value="${B.student.name}"/></td>
                <td><c:out value="${B.borrowedDate}"/></td>
                <td><c:out value="${B.returnDate}"/></td>
                <td>
                    <a href="deleteCard?id=${B.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
