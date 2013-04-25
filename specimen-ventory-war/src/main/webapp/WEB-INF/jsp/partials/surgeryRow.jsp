<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.specimen.inventory.model.AnesthesiaType" %>
<%@ page import="com.specimen.inventory.model.AnalgesiaType" %>
<%@ page import="com.specimen.inventory.model.SurgeryType" %>


<tr class="specimenRow">
    <td class="specimenAnimalIdTd">
        <span id="specimenAnimalIdSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.specimen.animalUUID}</span>
        <input class="edit hidden tiny" name="surgery.specimen.animalUUID" id="specimenAnimalIdInput-${surgery.surgery.id}" value="${surgery.surgery.specimen.animalUUID}"/>
        <input class="hidden" name="surgery.id" id="specimenSurgeryIdInput-${surgery.surgery.id}" value="${surgery.surgery.id}"/>
    </td>
    <td class="specimenProcedureTd">
        <%--<spring:url var="detailsUrl" value='surgeryDetails/${surgery.surgery.id}'/>--%>
        <%--<a id="specimenProcedureLink-${surgery.surgery.id}" class="nonEdit" href="${detailsUrl}">${surgery.surgery.procedureName}</a>--%>
        <%--&lt;%&ndash;<span id="specimenProcedureSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.procedureName}</span>&ndash;%&gt;--%>
        <%--<input class="edit hidden small" name="surgery.procedureName" id="specimenProcedureInput-${surgery.surgery.id}" value="${surgery.surgery.procedureName}"/>--%>
    </td>
    <td class="specimenNotesTd">
        <span id="specimenNotesSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.freeText}</span>
        <input class="edit hidden" name="surgery.freeText" id="specimenNotesInput-${surgery.surgery.id}" value="${surgery.surgery.freeText}"/>
    </td>
    <td class="specimenSurgeonTd">
        <span id="specimenSurgeonSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.surgeon}</span>
        <input class="edit hidden mini" name="surgery.surgeon" id="specimenSurgeonInput-${surgery.surgery.id}" value="${surgery.surgery.surgeon}"/>
    </td>
    <td class="specimenStartTd">
        <span id="specimenStartSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.timeStart}</span>
        <input class="edit hidden tiny" name="surgery.timeStart" id="specimenStartInput-${surgery.surgery.id}" value="${surgery.surgery.timeStart}"/>
    </td>
    <td class="specimenEndTd">
        <span id="specimenEndSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.timeEnd}</span>
        <input class="edit hidden tiny" name="surgery.timeEnd" id="specimenEndInput-${surgery.surgery.id}" value="${surgery.surgery.timeEnd}"/>
    </td>
    <td class="specimenDateDt">
        <fmt:formatDate value="${surgery.surgery.surgeryDate}" var="surgeryDate" pattern="MM/dd/yyyy"/>
        <span id="specimenDateSpan-${surgery.surgery.id}" class="nonEdit">${surgeryDate}</span>
        <input class="edit hidden mini" name="surgery.surgeryDate" id="specimenDateInput-${surgery.surgery.id}" value="${surgeryDate}"/>
    </td>
    <td class="specimenAnesthesiaTypeTd">
        <span id="specimenAnesthesiaTypeSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.anesthesiaType.medicine}</span>
        <select title="anesthesiaTypeSelect-${surgery.surgery.id}" id="analgesiaTypeSelect-${surgery.surgery.id}" name="surgery.anesthesiaType" class="small hidden edit">
            <c:forEach items="${anesthesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.surgery.anesthesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </td>
    <td class="specimenAnesthesiaDoseTd">
        <span id="specimenAnesthesiaDoseSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.anesthesiaDosage}</span>
        <input class="edit hidden mini" name="surgery.anesthesiaDosage" id="specimenAnesthesiaDoseInput-${surgery.surgery.id}" value="${surgery.surgery.anesthesiaDosage}"/>
    </td>
    <td class="specimenAnalgesiaTypeTd">
        <span id="specimenAnalgesiaTypeSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.analgesiaType.medicine}</span>
        <select title="analgesiaTypeSelect-${surgery.surgery.id}" id="analgesiaTypeSelect-${surgery.surgery.id}" name="surgery.analgesiaType" class="small hidden edit">
            <c:forEach items="${analgesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.surgery.analgesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </td>
    <td class="specimenAnalgesiaDoseTd">
        <span id="specimenAnalgesiaDoseSpan-${surgery.surgery.id}" class="nonEdit">${surgery.surgery.analgesiaDose}</span>
        <input class="edit hidden mini" name="surgery.analgesiaDose" id="specimenAnalgesiaDoseInput-${surgery.surgery.id}" value="${surgery.surgery.analgesiaDose}"/>
    </td>
    <td class="specimenButtonTd">
        <small>
            <button id="specimenSaveButton-${surgery.surgery.id}" class="surgeryButton saveButton edit hidden">
                <span class="ui-icon ui-icon-disk"></span>
            </button>
            <button id="specimenEditButton-${surgery.surgery.id}" class="surgeryButton editButton nonEdit">
                <span class="ui-icon ui-icon-pencil"></span>
            </button>
            <button id="specimenDeleteButton-${surgery.surgery.id}" class="surgeryButton deleteButton nonEdit">
                <span class="ui-icon ui-icon-trash"></span>
            </button>
            <button id="specimenCancelButton-${surgery.surgery.id}" class="surgeryButton cancelButton edit hidden">
                <span class="ui-icon ui-icon-cancel"></span>
            </button>
        </small>
    </td>
</tr>
