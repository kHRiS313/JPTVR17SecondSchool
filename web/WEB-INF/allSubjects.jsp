<%-- 
    Document   : allSubjects
    Created on : Oct 7, 2019, 6:30:10 PM
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
        <h1>Предметы</h1>
        <table style="text-align: center;">
            <th>ID</th>
            <th>Hours</th>
            <th>Name</th>
            <th>Control</th>
        <c:forEach var="subject" items="${listSubjects}">
        <tr>
            <td>${subject.id}</td>
            <td>${subject.hours}</td>
            <td><a href="SubjectGrades?id=${subject.id}">${subject.name}</a></td>
            <td><a href="editSubject?id=${subject.id}">Edit</a></td>
        </tr>   
       </c:forEach>
        </table>
        <a href='teacher'>Вернуться</a>
    </body>
</html>
