<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.specimen.inventory.model.AnesthesiaType" %>
<%@ page import="com.specimen.inventory.model.AnalgesiaType" %>
<%@ page import="com.specimen.inventory.model.Surgery" %>

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