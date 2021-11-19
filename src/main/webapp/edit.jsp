<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/home">List All Book</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit User
                </h2>
            </caption>
            <tr>
                <th>ID:</th>
                <td>
                    <input readonly type="text" name="id"
                           value="<c:out value='${book.id}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Name:</th>
                <td>
                    <input readonly type="text" name="book" size="45"
                           value="<c:out value='${book.name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Code:</th>
                <td>
                    <input readonly type="text" name="code"
                           value="<c:out value='${book.code}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Book Quantity:</th>
                <td>
                    <input readonly type="text" name="quantity" size="45"
                           value="<c:out value='${book.quantity}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Student:</th>
                <td>
                    <input type="text" name="student" size="50"/>"
                </td>
            </tr>
            <tr>
                <th>Code Card:</th>
                <td>
                    <input type="text" name="student" size="50"/>"
                </td>
            </tr>
            <tr>
                <th>Return date:</th>
                <td>
                    <input type="date" name="date" size="50"/>"
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
