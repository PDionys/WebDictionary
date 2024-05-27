<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Web Dictionary</title>
        <link rel="stylesheet" href="/WebDictionary/style.css">
        <link rel="stylesheet" href="/WebDictionary/style3.css">
    </head>
    <body>
        <%@ page session="true" %>
        <%@include file="/WEB-INF/jspf/header.jspf" %>
<!--        <h1>Hello Admin</h1>-->
        <c:forEach items="${dict}" var="word">
            <div style="margin: 8px; float: top;" class="word-box" onclick="toggleAdditionalBox(this)">
                <div style="display: flex;">
                    <h2 style="margin: 5px; float: left;font-size: 32px;"><c:out value="${word.getWord()}"/></h2> 
                    <!--<p style="font-style: italic; margin:25px; float:top;"></p>-->    
                </div>
<!--                <div class="button-container">
                    <input type="submit" value="" style="background-image: url('/WebDictionary/img/arrow.png'); 
                                background-size: 20px; 
                                background-repeat: no-repeat;
                                background-position: center;"/>
                    <form action="delete" method="POST">
                        <input type="submit" value="" style="background-image: url('/WebDictionary/img/delete.png'); 
                                background-size: 15px;
                                background-repeat: no-repeat;
                                background-position: center;"/>
                    </form>
                </div>-->
                <div id="Div1" class="additional-box" style="display: none;">
                    <c:forEach items="${word.getPartsOfSpeachCollection()}" var="pof">
                        <p style="text-decoration: underline; font-size: 18px;"><c:out value="${pof.getPof()}" /></p>
                        <c:forEach items="${pof.getMeaningsCollection()}" var="mean">
                            <p style="font-size: 18px;">--<c:out value="${mean.getMvalue()}" /></p>
                        </c:forEach>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
        <form action="edit" method="POST">
            <input id="STATE" name="STATE" style="display: none;" value="0"/>
            <input style="width: 50%; margin: 8px; float: top;" type="submit" value="+"/>
        </form>
    </body>
    <script>
        function toggleAdditionalBox(button) {
            var additionalBox = button.querySelector('.additional-box'); 
            
            if (additionalBox.style.display === 'none') {
                additionalBox.style.display = 'block';
            } else {
                additionalBox.style.display = 'none';
            }
        }
    </script>
</html>
