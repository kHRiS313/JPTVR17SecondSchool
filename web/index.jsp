<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Школа</title>
    </head>
    <body>
        <h1>Школа</h1>
        ${info}
        <c:set var="usercheck" value="${user.login}"></c:set>
        <c:if test="${usercheck != null}">
            <p>Вошедший пользователь: ${user.login}</p>
            
        </c:if>

        <h2>Профиль</h2>
        <c:if test="${usercheck == null}">
            <a href="showLogin">Вход</a><br>            
        </c:if>
        <c:if test="${usercheck != null}">
            <a href="showLogin">Сменить профиль</a><br>      
        </c:if>
        <c:if test="${usercheck != null}">
            <a href="logout">Выход</a><br>
        </c:if>

        <c:if test="${usercheck != null}">
            <c:set var="yourrole" value="${user.people.role}"></c:set>
            <br><b style="font-size: 24px;   font-weight: 600;">Меню</b>: 
                <c:if test="${yourrole == 0}">
                    <b style="font-size: 24px;   font-weight: 600;">Ученик</b><br>
                    <a href="StudentGrades">Посмотреть свои оценки</a>              
                </c:if>

                <c:if test="${yourrole == 1}">
                    <b style="font-size: 24px;   font-weight: 600;">Учитель</b>  <br>      
                    <a href="newJournal">Новая оценка</a><br>
                    <a href="allGrades">Все оценки</a><br>
                    <a href="allPeople">Все ученики</a><br>
                    <a href="allSubjects">Все предметы</a><br>

                </c:if>

                <c:if test="${yourrole == 2}">
                    <b style="font-size: 24px;   font-weight: 600;">Администратор</b> <br>
                    <a href="newPeople">Добавить новый профиль</a><br>
                    <a href="newSubject">Добавить новый предмет</a><br>
                    <a href="allSubjects">Все предметы</a><br>
                    <a href="allPeople">Все профили</a><br>
                </c:if>
            
        </c:if>

    </body>
</html>
