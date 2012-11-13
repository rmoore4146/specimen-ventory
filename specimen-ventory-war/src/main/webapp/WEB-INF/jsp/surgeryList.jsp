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
    <title>baby cat</title>
    <%--<link type="text/css" href="${contextPath}/site/css/dot-luv/jquery-ui-1.8.21.custom.css" rel="Stylesheet" />--%>
    <link type="text/css" href="${contextPath}/site/css/specimen-ventory/jquery-ui-1.9.1.custom.min.css" rel="Stylesheet" />
    <link rel="stylesheet" href="${contextPath}/site/css/specimen-ventory/jquery.dataTables_themeroller.css"/>
    <link type="text/css" href="${contextPath}/site/css/common.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/surgeryList.css" rel="Stylesheet" />
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/datatables-1.8.2/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/surgeryList.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/common.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-ui-1.9.1.custom.min.js"></script>
</head>
<body>
    <div id="pageContainer">
        <h1 title="Surgery Log">Surgery Log</h1>
        <div class="surgeryTableContainer">
            <table id="surgeryTable" cellpadding="0" cellspacing="0" border="0" class="display dataTable" >
                <thead>
                    <tr>
                        <th>Animal</th>
                        <th>Procedure</th>
                        <th>Notes</th>
                        <th>Surgeon</th>
                        <th>Start</th>
                        <th>End</th>
                        <th>Date</th>
                        <th>Anesthesia Type</th>
                        <th>Anesthesia Dose</th>
                        <th>Analgesia Type</th>
                        <th>Analgesia Dose</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${specimenSet}" var="specimen" varStatus="specimenIndex">
                        <c:forEach items="${specimen.surgeryList}" var="surgery" begin="0" end="1">
                            <tr class="specimenRow">
                                <td class="specimenAnimalIdTd">
                                    <span id="specimenAnimalIdSpan-${specimenIndex.index}">${specimen.animalUUID}</span>
                                    <input class="hidden" id="specimenAnimalIdInput-${specimenIndex.index}" value="${specimen.animalUUID}"/>
                                </td>
                                <td class="specimenProcedureTd">
                                    <span id="specimenProcedureSpan-${specimenIndex.index}">${surgery.procedureName}</span>
                                    <input class="hidden" id="specimenProcedureInput-${specimenIndex.index}" value="${surgery.procedureName}"/>
                                </td>
                                <td class="specimenNotesTd">
                                    <span id="specimenNotesSpan-${specimenIndex.index}">${surgery.freeText}</span>
                                    <input class="hidden" id="specimenNotesInput-${specimenIndex.index}" value="${surgery.freeText}"/>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td>
                                </td>
                                <td class="specimenButtonTd">
                                    <small>
                                        <button id="specimenEditButton-${specimenIndex.index}" class="surgeryButton">
                                            <span class="ui-icon ui-icon-pencil small"></span>
                                        </button>
                                        <button id="specimenDeleteButton-${specimenIndex.index}" class="surgeryButton">
                                            <span class="ui-icon ui-icon-trash small"></span>
                                        </button>
                                    </small>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
