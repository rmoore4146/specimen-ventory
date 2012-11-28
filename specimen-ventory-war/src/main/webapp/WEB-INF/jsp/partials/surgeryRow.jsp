<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.specimen.inventory.model.AnesthesiaType" %>
<%@ page import="com.specimen.inventory.model.AnalgesiaType" %>
<%@ page import="com.specimen.inventory.model.HeadSurgery" %>


<tr class="specimenRow">
    <td class="specimenAnimalIdTd">
        <span id="specimenAnimalIdSpan-${surgery.id}" class="nonEdit">${surgery.specimen.animalUUID}</span>
        <input class="edit hidden tiny" name="specimen.animalUUID" id="specimenAnimalIdInput-${surgery.id}" value="${surgery.specimen.animalUUID}"/>
        <input class="hidden" name="id" id="specimenSurgeryIdInput-${surgery.id}" value="${surgery.id}"/>
    </td>
    <td class="specimenProcedureTd">
        <spring:url var="detailsUrl" value='/specimen-ventory/surgeryDetails/${surgery.id}'/>
        <a id="specimenProcedureLink-${surgery.id}" class="nonEdit" href="${detailsUrl}">${surgery.procedureName}</a>
        <%--<span id="specimenProcedureSpan-${surgery.id}" class="nonEdit">${surgery.procedureName}</span>--%>
        <input class="edit hidden small" name="procedureName" id="specimenProcedureInput-${surgery.id}" value="${surgery.procedureName}"/>
    </td>
    <td class="specimenNotesTd">
        <span id="specimenNotesSpan-${surgery.id}" class="nonEdit">${surgery.freeText}</span>
        <input class="edit hidden" name="freeText" id="specimenNotesInput-${surgery.id}" value="${surgery.freeText}"/>
    </td>
    <td class="specimenSurgeonTd">
        <span id="specimenSurgeonSpan-${surgery.id}" class="nonEdit">${surgery.surgeon}</span>
        <input class="edit hidden mini" name="surgeon" id="specimenSurgeonInput-${surgery.id}" value="${surgery.surgeon}"/>
    </td>
    <td class="specimenStartTd">
        <span id="specimenStartSpan-${surgery.id}" class="nonEdit">${surgery.timeStart}</span>
        <input class="edit hidden tiny" name="timeStart" id="specimenStartInput-${surgery.id}" value="${surgery.timeStart}"/>
    </td>
    <td class="specimenEndTd">
        <span id="specimenEndSpan-${surgery.id}" class="nonEdit">${surgery.timeEnd}</span>
        <input class="edit hidden tiny" name="timeEnd" id="specimenEndInput-${surgery.id}" value="${surgery.timeEnd}"/>
    </td>
    <td class="specimenDateDt">
        <fmt:formatDate value="${surgery.surgeryDate}" var="surgeryDate" pattern="MM/dd/yyyy"/>
        <span id="specimenDateSpan-${surgery.id}" class="nonEdit">${surgeryDate}</span>
        <input class="edit hidden mini" name="surgeryDate" id="specimenDateInput-${surgery.id}" value="${surgeryDate}"/>
    </td>
    <td class="specimenAnesthesiaTypeTd">
        <span id="specimenAnesthesiaTypeSpan-${surgery.id}" class="nonEdit">${surgery.anesthesiaType.medicine}</span>
        <select title="anesthesiaTypeSelect-${surgery.id}" id="analgesiaTypeSelect-${surgery.id}" name="anesthesiaType" class="small hidden edit">
            <c:forEach items="${anesthesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.anesthesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </td>
    <td class="specimenAnesthesiaDoseTd">
        <span id="specimenAnesthesiaDoseSpan-${surgery.id}" class="nonEdit">${surgery.anesthesiaDosage}</span>
        <input class="edit hidden mini" name="anesthesiaDosage" id="specimenAnesthesiaDoseInput-${surgery.id}" value="${surgery.anesthesiaDosage}"/>
    </td>
    <td class="specimenAnalgesiaTypeTd">
        <span id="specimenAnalgesiaTypeSpan-${surgery.id}" class="nonEdit">${surgery.analgesiaType.medicine}</span>
        <select title="analgesiaTypeSelect-${surgery.id}" id="analgesiaTypeSelect-${surgery.id}" name="analgesiaType" class="small hidden edit">
            <c:forEach items="${analgesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.analgesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </td>
    <td class="specimenAnalgesiaDoseTd">
        <span id="specimenAnalgesiaDoseSpan-${surgery.id}" class="nonEdit">${surgery.analgesiaDose}</span>
        <input class="edit hidden mini" name="analgesiaDose" id="specimenAnalgesiaDoseInput-${surgery.id}" value="${surgery.analgesiaDose}"/>
    </td>
    <td class="specimenButtonTd">
        <small>
            <button id="specimenSaveButton-${surgery.id}" class="surgeryButton saveButton edit hidden">
                <span class="ui-icon ui-icon-disk"></span>
            </button>
            <button id="specimenEditButton-${surgery.id}" class="surgeryButton editButton nonEdit">
                <span class="ui-icon ui-icon-pencil"></span>
            </button>
            <button id="specimenDeleteButton-${surgery.id}" class="surgeryButton deleteButton nonEdit">
                <span class="ui-icon ui-icon-trash"></span>
            </button>
            <button id="specimenCancelButton-${surgery.id}" class="surgeryButton cancelButton edit hidden">
                <span class="ui-icon ui-icon-cancel"></span>
            </button>
        </small>
    </td>
</tr>
