<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Школа</title>
    </head>
    <body>
       <form action="newJournal" method="POST">
        <h1>Выставление оценки</h1>
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
        
        Выберите оценку: 
        <input type="radio" name="grade" value="!" required>!
        <input type="radio" name="grade" value="1">1
        <input type="radio" name="grade" value="2">2
        <input type="radio" name="grade" value="3">3
        <input type="radio" name="grade" value="4">4
        <input type="radio" name="grade" value="5">5
        <br><br>
        <input type="submit" vlaue="Поставить оценку">
    </form>
    <a href='./'>Вернуться</a>
    </body>
</html>
