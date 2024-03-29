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
    <title>Specimen Inventory: Create Surgery</title>
    <%--<link type="text/css" href="${contextPath}/site/css/dot-luv/jquery-ui-1.8.21.custom.css" rel="Stylesheet" />--%>
    <link type="text/css" href="${contextPath}/site/css/specimen-ventory/jquery-ui-1.9.1.custom.min.css" rel="Stylesheet" />
    <link rel="stylesheet" href="${contextPath}/site/css/specimen-ventory/jquery.dataTables_themeroller.css"/>
    <link type="text/css" href="${contextPath}/site/css/common.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/header.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/bootstrap/css/bootstrap-responsive.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/bootstrap/css/bootstrap.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/createSurgery.css" rel="Stylesheet" />`
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/datatables-1.8.2/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/createSurgery.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/common.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-ui-1.9.1.custom.min.js"></script>
</head>
<body>
<div id="pageContainer">
    <%--Include page header--%>
    <%@include file="headers/createSurgeryHeader.jsp"%>
    <form id="surgeryForm" class="form-horizontal">
        <div class="surgeryContainer">
            <%@include file="partials/surgeryFormFields.jsp"%>
        </div>
    </form>
    <br>
    <div class="buttonContainer">
        <small>
            <button id="specimenSaveButton" class="surgeryButton saveButton edit">
                <span class="ui-icon ui-icon-disk"></span>
            </button>
        </small>
    </div>
</div>
</body>
</html>

<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}" + '/';
    common.initEvents();
</script>
