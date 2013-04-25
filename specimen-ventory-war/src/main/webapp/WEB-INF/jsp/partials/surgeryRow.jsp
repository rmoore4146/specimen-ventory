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
        <span id="specimenAnimalIdSpan-${surgery.surgery.id}">${surgery.surgery.specimen.animalUUID}</span>
        <input class="hidden" name="surgery.id" id="specimenSurgeryIdInput-${surgery.surgery.id}" value="${surgery.surgery.id}"/>
    </td>
    <td class="specimenProcedureTd">
        <c:forEach items="${surgery.procedures}" var="procedure">
            <span class="surgeryType"><span>${procedure}</span></span>
        </c:forEach>
    </td>
    <td class="specimenSurgeryTypeTd">
        <c:forEach items="${surgery.surgeryTypes}" var="type">
            <span class="surgeryType"><span>${type.surgeryType}</span></span>
        </c:forEach>
    </td>
    <td class="specimenNotesTd">
        <span id="specimenNotesSpan-${surgery.surgery.id}">${surgery.surgery.freeText}</span>
    </td>
    <td class="specimenSurgeonTd">
        <span id="specimenSurgeonSpan-${surgery.surgery.id}">${surgery.surgery.surgeon}</span>
    </td>
    <td class="specimenStartTd">
        <span id="specimenStartSpan-${surgery.surgery.id}">${surgery.surgery.timeStart}</span>
    </td>
    <td class="specimenEndTd">
        <span id="specimenEndSpan-${surgery.surgery.id}">${surgery.surgery.timeEnd}</span>
    </td>
    <td class="specimenDateDt">
        <fmt:formatDate value="${surgery.surgery.surgeryDate}" var="surgeryDate" pattern="MM/dd/yyyy"/>
        <span id="specimenDateSpan-${surgery.surgery.id}">${surgeryDate}</span>
    </td>
    <td class="specimenAnesthesiaTypeTd">
        <span id="specimenAnesthesiaTypeSpan-${surgery.surgery.id}">${surgery.surgery.anesthesiaType.medicine}</span>
    </td>
    <td class="specimenAnesthesiaDoseTd">
        <span id="specimenAnesthesiaDoseSpan-${surgery.surgery.id}">${surgery.surgery.anesthesiaDosage}</span>
    </td>
    <td class="specimenAnalgesiaTypeTd">
        <span id="specimenAnalgesiaTypeSpan-${surgery.surgery.id}">${surgery.surgery.analgesiaType.medicine}</span>
    </td>
    <td class="specimenAnalgesiaDoseTd">
        <span id="specimenAnalgesiaDoseSpan-${surgery.surgery.id}">${surgery.surgery.analgesiaDose}</span>
    </td>
    <td class="specimenButtonTd">
        <small>
            <button id="specimenEditButton-${surgery.surgery.id}" class="surgeryButton editButton">
                <span class="ui-icon ui-icon-pencil"></span>
            </button>
            <button id="specimenDeleteButton-${surgery.surgery.id}" class="surgeryButton deleteButton">
                <span class="ui-icon ui-icon-trash"></span>
            </button>
        </small>
    </td>
</tr>
