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
        <c:set var="yourrole" value="${user.people.role}"></c:set>
            <h1>Предметы</h1>
            <table style="text-align: center;">
                <th>ID</th>
                <th>Hours</th>
                <th>Name</th>
                <c:if test="${yourrole == 2}">
                <th>Control</th>
                </c:if>
                <c:forEach var="subject" items="${listSubjects}">
                <tr>
                    <td>${subject.id}</td>
                    <td>${subject.hours}</td>
                    <td><a href="SubjectGrades?id=${subject.id}">${subject.name}</a></td>
                        <c:if test="${yourrole == 2}">
                        <td><a href="editSubject?id=${subject.id}">Edit</a></td>
                    </c:if>

                </tr>   
            </c:forEach>
        </table>
        <a href='./'>Вернуться</a>
    </body>
</html>
