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
                        <c:forEach items="${specimen.surgeryList}" var="surgery" begin="0" end="0">
                            <form class="someform">
                            <tr class="specimenRow">
                                <td class="specimenAnimalIdTd">
                                    <span id="specimenAnimalIdSpan-${specimenIndex.index}" class="nonEdit">${specimen.animalUUID}</span>
                                    <input class="edit hidden tiny" id="specimenAnimalIdInput-${specimenIndex.index}" value="${specimen.animalUUID}"/>
                                </td>
                                <td class="specimenProcedureTd">
                                    <span id="specimenProcedureSpan-${specimenIndex.index}" class="nonEdit">${surgery.procedureName}</span>
                                    <input class="edit hidden small" id="specimenProcedureInput-${specimenIndex.index}" value="${surgery.procedureName}"/>
                                </td>
                                <td class="specimenNotesTd">
                                    <span id="specimenNotesSpan-${specimenIndex.index}" class="nonEdit">${surgery.freeText}</span>
                                    <input class="edit hidden" id="specimenNotesInput-${specimenIndex.index}" value="${surgery.freeText}"/>
                                </td>
                                <td class="specimenSurgeonTd">
                                    <span id="specimenSurgeonSpan-${specimenIndex.index}" class="nonEdit">${surgery.surgeon}</span>
                                    <input class="edit hidden mini" id="specimenSurgeonInput-${specimenIndex.index}" value="${surgery.surgeon}"/>
                                </td>
                                <td class="specimenStartTd">
                                    <span id="specimenStartSpan-${specimenIndex.index}" class="nonEdit">${surgery.timeStart}</span>
                                    <input class="edit hidden tiny" id="specimenStartInput-${specimenIndex.index}" value="${surgery.timeStart}"/>
                                </td>
                                <td class="specimenEndTd">
                                    <span id="specimenEndSpan-${specimenIndex.index}" class="nonEdit">${surgery.timeEnd}</span>
                                    <input class="edit hidden tiny" id="specimenEndInput-${specimenIndex.index}" value="${surgery.timeEnd}"/>
                                </td>
                                <td class="specimenDateDt">
                                    <fmt:formatDate value="${surgery.surgeryDate}" var="surgeryDate" pattern="mm-dd-yyyy"/>
                                    <span id="specimenDateSpan-${specimenIndex.index}" class="nonEdit">${surgeryDate}</span>
                                    <input class="edit hidden mini" id="specimenDateInput-${specimenIndex.index}" value="${surgeryDate}"/>
                                </td>
                                <td class="specimenAnesthesiaTypeTd">
                                    <span id="specimenAnesthesiaTypeSpan-${specimenIndex.index}" class="nonEdit">${surgery.anesthesiaType}</span>
                                    <input class="edit hidden" id="specimenAnesthesiaTypeInput-${specimenIndex.index}" value="${surgery.anesthesiaType}"/>
                                </td>
                                <td class="specimenAnesthesiaDoseTd">
                                    <span id="specimenAnesthesiaDoseSpan-${specimenIndex.index}" class="nonEdit">${surgery.anesthesiaDosage}</span>
                                    <input class="edit hidden mini" id="specimenAnesthesiaDoseInput-${specimenIndex.index}" value="${surgery.anesthesiaDosage}"/>
                                </td>
                                <td class="specimenAnalgesiaTypeTd">
                                    <span id="specimenAnalgesiaTypeSpan-${specimenIndex.index}" class="nonEdit">${surgery.analgesiaType}</span>
                                    <input class="edit hidden" id="specimenAnalgesiaTypeInput-${specimenIndex.index}" value="${surgery.analgesiaType}"/>
                                </td>
                                <td class="specimenAnalgesiaDoseTd">
                                    <span id="specimenAnalgesiaDoseSpan-${specimenIndex.index}" class="nonEdit">${surgery.analgesiaDose}</span>
                                    <input class="edit hidden mini" id="specimenAnalgesiaDoseInput-${specimenIndex.index}" value="${surgery.analgesiaDose}"/>
                                </td>
                                <td class="specimenButtonTd">
                                    <small>
                                        <button id="specimenSaveButton-${specimenIndex.index}" class="surgeryButton saveButton edit hidden">
                                            <span class="ui-icon ui-icon-disk"></span>
                                        </button>
                                        <button id="specimenEditButton-${specimenIndex.index}" class="surgeryButton editButton nonEdit">
                                            <span class="ui-icon ui-icon-pencil"></span>
                                        </button>
                                        <button id="specimenDeleteButton-${specimenIndex.index}" class="surgeryButton deleteButton nonEdit">
                                            <span class="ui-icon ui-icon-trash"></span>
                                        </button>
                                        <button id="specimenCancelButton-${specimenIndex.index}" class="surgeryButton cancelButton edit hidden">
                                            <span class="ui-icon ui-icon-cancel"></span>
                                        </button>
                                    </small>
                                </td>
                            </tr>
                            </form>
                        </c:forEach>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
