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
    <h2>
        <a href="/card">List Card</a>
    </h2>
    <h2>
        <a href="/cardTrue">List Card True</a>
    </h2>
    <p><a href="/home">List Book</a></p>
    <form action="/search" >
        <input type="text" name="book" placeholder="book name">
        <input type="submit" value="search">
    </form>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="B" items="${list}">
            <tr>
                <td><c:out value="${B.id}"/></td>
                <td><c:out value="${B.name}"/></td>
                <td><c:out value="${B.quantity}"/></td>
                <td>
                    <a href="/borrow?id=${B.id}">muon</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
