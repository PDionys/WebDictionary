<%-- 
    Document   : login-page
    Created on : Mar 21, 2024, 5:20:00 PM
    Author     : Denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Web Dictionary</title>
        <link rel="stylesheet" href="style2.css">
    </head>
    <body>
        <div class="login-container">
            <h2>Login</h2>
            <form action="login" method="post">
                <input type="text" name="username" placeholder="Username" required>
                <input type="password" name="password" placeholder="Password" required>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>
