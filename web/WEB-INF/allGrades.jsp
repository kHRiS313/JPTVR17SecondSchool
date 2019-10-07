<%-- 
    Document   : allGrades
    Created on : Oct 7, 2019, 6:29:00 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Оценки</h1>
        <table style='text-align: center;'>
            <th>ID</th>
            <th>Date</th>
            <th>Grade</th>
            <th>Student ID</th>
            <th>Subject ID</th>
            <th>Teacher ID</th>
            <th>Control</th>
            <c:forEach var="journal" items="${listJournals}">
                <tr>
                    <td>${journal.id}</td>
                    <td>${journal.date}</td>
                    <td>${journal.grade}</td>
                    <td>${journal.student.name}</td>
                    <td>${journal.subject.name}</td>
                    <td>${journal.teacher.name}</td>
                    <td><a href="editGrade?id=${journal.id}">Edit</a></td>
                </tr>   
           </c:forEach>
        </table>
        <a href='teacher'>Вернуться</a>
    </body>
</html>
