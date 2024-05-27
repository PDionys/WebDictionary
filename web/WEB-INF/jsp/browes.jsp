<%-- 
    Document   : browes
    Created on : Mar 6, 2024, 5:28:17 PM
    Author     : Denis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Web Dictionary</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <%@include file="/WEB-INF/jspf/header.jspf" %>
    <body>
        
        <c:set var="type_c" scope="page" value="${type}"/>
        <c:set var="word_cc" scope="page" value="${word}"/>
        
        <c:if test="${type_c eq 'expl'}">
            <c:forEach items="${word_cc}" var="word_c">
            <div class="dictionary-box">
                <h2><c:out value="${word_c.getWordname()}"/></h2>
                <p style="font-style: italic;"><c:out value="${word_c.getTranscription()}"/></p>
                <c:forEach items="${word_c.getMeaning()}" var="e">
                    <p style="text-decoration: underline;"><c:out value="${e.key}" /></p>
                    <c:forEach items="${e.value}" var="l">
                        <p><c:out value="${l.getMvalue()}" /></p>
                    </c:forEach>
                </c:forEach>
            </div>
            </c:forEach>
        </c:if>
        <c:if test="${type_c eq 'biling'}">
            <div class="box">Hello biling</div>
        </c:if>
    </body>
</html>
