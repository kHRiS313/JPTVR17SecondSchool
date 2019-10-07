<%-- 
    Document   : editGrade
    Created on : Oct 7, 2019, 6:34:38 PM
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
        <h1>Edit Journal</h1>
        <form action="changeJournal" method="POST">
            <input type="hidden" name="id" value="${journal.id}">
            <input type="hidden" name="date" value="${journal.date}">
            Выберите оценку: 
                <input type="radio" name="grade" value="!" required>!
                <input type="radio" name="grade" value="1">1
                <input type="radio" name="grade" value="2">2
                <input type="radio" name="grade" value="3">3
                <input type="radio" name="grade" value="4">4
                <input type="radio" name="grade" value="5">5<br>
                Выберите ученика: 
        <select name="student">
            <c:forEach var="student" items="${listStudents}">
                    <option value="${student.id}">${student.name}</option>      
                    </c:forEach>
        </select><br><br>
        
        Выберите учителя:
        <select name="teacher">
            <c:forEach var="teacher" items="${listTeachers}">
                    <option value="${teacher.id}">${teacher.name}</option>    
                    </c:forEach>
        </select><br><br>
        
        Выберите предмет:
        <select name="subject">
            <c:forEach var="subject" items="${listSubjects}">
                    <option value="${subject.id}">${subject.name}</option>
            </c:forEach>
        </select><br><br>
        <input type="submit" value="save">
        </form>
            <a href='allGrades'>Вернуться</a>
    </body>
</html>
