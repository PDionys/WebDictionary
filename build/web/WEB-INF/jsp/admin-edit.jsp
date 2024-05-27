<%-- 
    Document   : admin-edit
    Created on : May 14, 2024, 2:49:12 PM
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
<!--        <link rel="stylesheet" href="/WebDictionary/style.css">
        <link rel="stylesheet" href="/WebDictionary/style3.css">-->
    <style>
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"],
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        textarea {
            height: 150px; /* Adjust height as needed */
        }
        input[type="submit"]{
            padding: 20px 15px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover{
            background-color: #45a049;
        }
        select{
            padding: 8px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #fff;
            cursor: pointer;
            outline: none;
            margin-left: 10px;
        }

        select:hover{
            border-color: #999;
        }

        select:focus{
            border-color: #007bff;
            box-shadow: 0 0 0 0.2rem rgb(0, 123, 255, 0.25);
        }
    </style>
    </head>
    <body>
        <c:choose>
            <c:when test="${pSTATE eq 0}">
                <c:set var="word" value="${dict}"/>
                <form action="edit" method="POST">
                <div style="display: flex; align-items: center;">
                    <select id="word-list" name="word-list">
                        <option value="new-word">New Word</option>
                        <c:forEach items="${word}" var="w">
                            <option value="${w.getWord()}"><c:out value="${w.getWord()}"/></option>
                        </c:forEach>
                    </select>
                    
                        <input id="STATE" name="STATE" style="display: none;" value="1"/>
                        <input style="margin: 8px; float: left;
                               background-image: url('/WebDictionary/img/check.png'); 
                               background-size: contain; background-repeat: no-repeat; 
                               padding-left: 20px; height: 10px" type="submit" value=""/>
                </div>
                </form>
            </c:when>
            <c:when test="${pSTATE eq 1}">
                <form action="edit" method="POST">
                <div>
                    <label for="word-name">Word Name:</label>
                    <input id="wState" name="wState" style="display: none;" value="${wSTATE}"/>
                    <c:if test="${wSTATE eq 'e'}">
                        <input id="exist-word" name="exist-word" style="display: none;" value="${eWord.getWord()}"/>
                        <input type="text" id="word-name" name="word-name" value="${eWord.getWord()}">  
                    </c:if>
                    <c:if test="${wSTATE eq 'n'}">
                        <input type="text" id="word-name" name="word-name">  
                    </c:if>
                    <!--<input type="text" id="word-name" name="word-name">-->  
                </div>
                <div>
                    <label for="speech">Speech:</label>
                    <c:if test="${wSTATE eq 'e'}">
                        <input type="text" id="speech" name="speech" value="${eWord.toString()}">  
                    </c:if>
                    <c:if test="${wSTATE eq 'n'}">
                        <input type="text" id="speech" name="speech">
                    </c:if>
<!--                    <input type="text" id="speech" name="speech">-->
                </div>
                <div>
                    <label for="meaning">Meaning:</label>
                    <c:if test="${wSTATE eq 'e'}">
                        <textarea id="meaning" name="meaning"><c:out value="${eWord.toStringPoF()}"/></textarea>  
                    </c:if>
                    <c:if test="${wSTATE eq 'n'}">
                        <textarea id="meaning" name="meaning"></textarea>
                    </c:if>
<!--                    <textarea id="meaning" name="meaning"></textarea>-->
                </div>
                    <!--<input id="STATE" name="STATE" style="display: none;" value="2"/>-->
                    <input id ="STATE" name="STATE" type="submit" value="Submit"/>
                    <input id="STATE" name="STATE" type="submit" value="Delete" style="background-color: red;"/>
                </form>
            </c:when>
        </c:choose>
    </body>
</html>
