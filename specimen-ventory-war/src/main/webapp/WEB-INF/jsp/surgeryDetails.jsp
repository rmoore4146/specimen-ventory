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
    <title>Surgery Details</title>
    <%--<link type="text/css" href="${contextPath}/site/css/dot-luv/jquery-ui-1.8.21.custom.css" rel="Stylesheet" />--%>
    <link type="text/css" href="${contextPath}/site/css/specimen-ventory/jquery-ui-1.9.1.custom.min.css" rel="Stylesheet" />
    <link rel="stylesheet" href="${contextPath}/site/css/specimen-ventory/jquery.dataTables_themeroller.css"/>
    <link type="text/css" href="${contextPath}/site/css/common.css" rel="Stylesheet" />
    <link type="text/css" href="${contextPath}/site/css/surgeryDetails.css" rel="Stylesheet" />
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-1.8.2.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/datatables-1.8.2/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/surgeryDetails.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/common.js"></script>
    <script type="text/javascript" src="${contextPath}/site/javascript/jquery-ui-1.9.1.custom.min.js"></script>
</head>
<body>
    <div id="pageContainer">
        <form id="surgeryForm">
            <div class="surgeryContainer">
            <h1 title="Surgery Log">${surgery.surgeryType} - ${surgery.procedureName}</h1>
                <ul class="formFields col2">
                    <li class="specimenAnimalIdLi">
                        <label class="surgeryDateLabel">Specimen UUID: </label>
                        <span id="specimenAnimalIdSpan" class="nonEdit">${surgery.specimen.animalUUID}</span>
                        <input class="edit hidden tiny" name="specimen.animalUUID" id="specimenAnimalIdInput" value="${surgery.specimen.animalUUID}"/>
                        <input class="hidden" name="id" id="specimenSurgeryIdInput" value="${surgery.id}"/>
                    </li>
                    <li class="specimenProcedureLi">
                        <label class="surgeryDateLabel">Procedure: </label>
                        <span id="specimenProcedureSpan" class="nonEdit">${surgery.procedureName}</span>
                        <input class="edit hidden small" name="procedureName" id="specimenProcedureInput" value="${surgery.procedureName}"/>
                    </li>
                    <li class="specimenSurgeonLi">
                        <label class="surgeryDateLabel">Surgeon: </label>
                        <span id="specimenSurgeonSpan" class="nonEdit">${surgery.surgeon}</span>
                        <input class="edit hidden mini" name="surgeon" id="specimenSurgeonInput" value="${surgery.surgeon}"/>
                    </li>
                    <li class="specimenStartLi">
                        <label class="surgeryDateLabel">Start Time: </label>
                        <span id="specimenStartSpan" class="nonEdit">${surgery.timeStart}</span>
                        <input class="edit hidden tiny" name="timeStart" id="specimenStartInput" value="${surgery.timeStart}"/>
                    </li>
                    <li class="specimenEndLi">
                        <label class="surgeryDateLabel">End Time: </label>
                        <span id="specimenEndSpan" class="nonEdit">${surgery.timeEnd}</span>
                        <input class="edit hidden tiny" name="timeEnd" id="specimenEndInput" value="${surgery.timeEnd}"/>
                    </li>
                    <li class="specimenDateDt">
                        <label class="surgeryDateLabel">Surgery Date: </label>
                        <fmt:formatDate value="${surgery.surgeryDate}" var="surgeryDate" pattern="MM/dd/yyyy"/>
                        <span id="specimenDateSpan" class="nonEdit">${surgeryDate}</span>
                        <input class="edit hidden mini" name="surgeryDate" id="specimenDateInput" value="${surgeryDate}"/>
                    </li>
                    <li class="specimenAnesthesiaTypeLi">
                        <label class="surgeryDateLabel">Anesthesia Type: </label>
                        <span id="specimenAnesthesiaTypeSpan" class="nonEdit">${surgery.anesthesiaType.medicine}</span>
                        <select title="anesthesiaTypeSelect" id="anesthesiaTypeSelect" name="anesthesiaType" class="small hidden edit">
                            <c:forEach items="${anesthesiaTypes}" var="value">
                                <option value="${value}" <c:if test="${value == surgery.anesthesiaType}">selected="selected"</c:if>>${value.medicine}</option>
                            </c:forEach>
                        </select>
                    </li>
                    <li class="specimenAnesthesiaDoseLi">
                        <label class="surgeryDateLabel">Anesthesia Dose: </label>
                        <span id="specimenAnesthesiaDoseSpan" class="nonEdit">${surgery.anesthesiaDosage}</span>
                        <input class="edit hidden mini" name="anesthesiaDosage" id="specimenAnesthesiaDoseInput" value="${surgery.anesthesiaDosage}"/>
                    </li>
                    <li class="specimenAnalgesiaTypeLi">
                        <label class="surgeryDateLabel">Analgesia Type: </label>
                        <span id="specimenAnalgesiaTypeSpan" class="nonEdit">${surgery.analgesiaType.medicine}</span>
                        <select title="analgesiaTypeSelect" id="analgesiaTypeSelect" name="analgesiaType" class="small hidden edit">
                            <c:forEach items="${analgesiaTypes}" var="value">
                                <option value="${value}" <c:if test="${value == surgery.analgesiaType}">selected="selected"</c:if>>${value.medicine}</option>
                            </c:forEach>
                        </select>
                    </li>
                    <li class="specimenAnalgesiaDoseLi">
                        <label class="surgeryDateLabel">Analgesia Dose: </label>
                        <span id="specimenAnalgesiaDoseSpan" class="nonEdit">${surgery.analgesiaDose}</span>
                        <input class="edit hidden mini" name="analgesiaDose" id="specimenAnalgesiaDoseInput" value="${surgery.analgesiaDose}"/>
                    </li>
                    <li class="specimenNotesLi">
                        <label class="surgeryDateLabel">Notes: </label>
                        <span id="specimenNotesSpan" class="nonEdit">${surgery.freeText}</span>
                        <input class="edit hidden" name="freeText" id="specimenNotesInput" value="${surgery.freeText}"/>
                    </li>
                </ul>
            </div>
        </form>
        <br>
        <div class="buttonContainer">
            <small>
                <button id="specimenSaveButton" class="surgeryButton saveButton edit hidden">
                    <span class="ui-icon ui-icon-disk"></span>
                </button>
                <button id="specimenEditButton" class="surgeryButton editButton nonEdit">
                    <span class="ui-icon ui-icon-pencil"></span>
                </button>
                <button id="specimenDeleteButton" class="surgeryButton deleteButton nonEdit">
                    <span class="ui-icon ui-icon-trash"></span>
                </button>
                <button id="specimenCancelButton" class="surgeryButton cancelButton edit hidden">
                    <span class="ui-icon ui-icon-cancel"></span>
                </button>
            </small>
        </div>
    </div>
</body>
</html>
