<%-- 
    Document   : editSubject
    Created on : Oct 7, 2019, 6:34:53 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit</h1>
        <form action="changeSubject" method="POST">
            <input type="hidden" name="id" value="${subject.id}">
            Название: <input type="text" name="name" value="${subject.name}"><br>
            Часы: <input type="text" name="hours" value="${subject.hours}"><br>
            <input type="submit" value="Save">
        </form>
            <a href='allSubjects'>Вернуться</a>
    </body>
</html>
