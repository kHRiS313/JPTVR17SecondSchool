<%-- 
    Document   : newPeople
    Created on : Oct 3, 2019, 8:45:51 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Школа</title>
    </head>
    <body>
        <h1>Новая учетная запись</h1>
        <form action="newPeople" method="POST">
            Имя: <input type="text" name="peopleName"><br><br>
            Роль:<br>
            <input type="radio" name="role" value="1"> Teacher<br>
            <input type="radio" name="role" value="0"> Student<br><br>
            <input type="submit" valu="Подтвердить">
        </form>
        <h2>Создан пользователь: ${people.name}, ${people.role}</h2>
    </body>
</html>
