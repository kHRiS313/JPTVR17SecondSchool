<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            
        </select><br><br>
        
        Выберите учителя:
        <select name="teacher">
            
        </select><br><br>
        
        Выберите предмет:
        <select name="subject">
            
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
    </body>
</html>
