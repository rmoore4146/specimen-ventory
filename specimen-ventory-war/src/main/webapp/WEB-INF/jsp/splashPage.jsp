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
    <title>Splash!!</title>
    <link type="text/css" href="${contextPath}/site/css/smoothness/jquery-ui-1.8.21.custom.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/common.css" rel="Stylesheet" />
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/splashPage.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/common.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-ui-1.8.21.custom.min.js"></script>
</head>
<body>
    <div id="bodyDiv">
        <div id="pictureDiv">
        </div>
        <img src="site/img/baby_punch.jpg" alt="" name="baby_punch"id=""/>
        </br>
        <button type="button" id="continueButton" class="continueButton">
            <span>Continue</span>
        </button>
    </div>
</body>
</html>
