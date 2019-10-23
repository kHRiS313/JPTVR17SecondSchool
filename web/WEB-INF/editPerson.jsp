<%-- 
    Document   : editPerson
    Created on : Oct 7, 2019, 6:34:45 PM
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
        <h1>Edit Person</h1>
        <form action="changePerson" method="POST">
            <input type="hidden" name="id" value="${person.id}">
            Имя: <input type="text" name="name" value="${person.name}"><br>
            Роль: <input type="number" name="role" min="0" max="2" value="${person.role}"><br>
            <input type="submit" value="Save">
        </form>
            <a href='allPeople'>Вернуться</a>
    </body>
</html>
