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
        <c:set var="yourrole" value="${user.people.role}"></c:set>
            <h1>Пользователи</h1>
            <table style="text-align: center;">
                <th>ID</th>
                <th>Name</th>
                <th>Role</th>
                <c:if test="${yourrole == 2}">
                <th>Control</th>
                </c:if>

            <c:forEach var="subject" items="${listPeople}">
                <tr>
                    <td>${subject.id}</td>
                    <c:if test="${subject.role == 0}">
                        <c:if test="${yourrole == 2}">
                            <td><a href="StudentGradesAdmin?id=${subject.id}">${subject.name}</a></td>
                        </c:if>
                        <c:if test="${yourrole == 1}">
                            <td><a href='StudentGrades?id=${subject.id}'>${subject.name}</a></td>
                            </c:if>

                    </c:if>
                    <c:if test="${subject.role == 1}">
                        <td>${subject.name}</td>
                    </c:if>
                    <c:if test="${subject.role == 2}">
                        <td>${subject.name}</td>
                    </c:if>
                    <td>${subject.role}</td>

                    <c:if test="${yourrole == 2}">
                        <td><a href="editPerson?id=${subject.id}">Edit</a></td>
                    </c:if>

                </tr>   
            </c:forEach>
        </table>
        <a href='./'>Вернуться</a>
    </body>
</html>
