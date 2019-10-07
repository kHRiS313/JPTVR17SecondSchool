<%-- 
    Document   : allPeople
    Created on : Oct 7, 2019, 6:34:24 PM
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Пользователи</h1>
        <table style="text-align: center;">
            <th>ID</th>
            <th>Hours</th>
            <th>Name</th>
            <th>Role</th>
            <th>Control</th>
        <c:forEach var="subject" items="${listPeople}">
        <tr>
            <td>${subject.id}</td>
            <c:if test="${subject.role == 0}">
                <td><a href='StudentGrades?id=${subject.id}'>${subject.name}</a></td>
            </c:if>
            <c:if test="${subject.role == 1}">
                <td>${subject.name}</td>
            </c:if>
            <td>${subject.name}</td>
            <td>${subject.role}</td>
            <td><a href="editPerson?id=${subject.id}">Edit</a></td>
        </tr>   
       </c:forEach>
        </table>
        <a href='teacher'>Вернуться</a>
    </body>
</html>
