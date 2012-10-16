<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Warning</title>
    <link type="text/css" href="${contextPath}/site/css/warning.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/common.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/ryanmoore-site/jquery-ui-1.8.21.custom.css" rel="Stylesheet" />
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/warning.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/common.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-ui-1.8.21.custom.min.js"></script>
    <%--Some hidden inputs we need for some javacript goodness--%>
    <input class="hidden" id="devilsUrl" value="${devilsUrl}"/>
    <input class="hidden" id="yanksUrl" value="${yanksUrl}"/>
    <input class="hidden" id="giantsUrl" value="${giantsUrl}"/>
    <input class="hidden" id="knicksUrl" value="${knicksUrl}"/>
</head>
<body>
    <div id="bodyDiv">
        <div id="draggableContainer" class="draggable ui-widget-content">
            <h3 id="warningDivHeader" class="draggableContained">Warning!!!!!!!</h3> </br></br>
            <p>You are about to enter a Devils, Giants, Yankees, and Knicks only zone. Please,
            for the love of jesus, press the 'Cancel' button if you can't handle that. Especially if you are a
            Philly sports fan. Thank you.</p>
        </div>
        <button type="button" id="continueButton" class="continueButton">
            <span class="ui-button-text">Enter</span>
        </button>
        <button type="button" id="cancelButton" class="cancelButton">
            <span class="ui-button-text">Cancel</span>
        </button>
    </div>
</body>
</html>
