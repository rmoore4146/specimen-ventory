<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.specimen.inventory.model.AnesthesiaType" %>
<%@ page import="com.specimen.inventory.model.AnalgesiaType" %>
<%@ page import="com.specimen.inventory.model.SurgeryType" %>

<ul class="formFields col2">
    <li class="specimenAnimalIdLi">
        <label class="surgeryDateLabel">Specimen UUID: </label>
        <span id="specimenAnimalIdSpan" class="nonEdit">${surgery.surgery.specimen.animalUUID}</span>
        <input class="edit hidden tiny" name="surgery.specimen.animalUUID" id="specimenAnimalIdInput" value="${surgery.surgery.specimen.animalUUID}"/>
        <input class="hidden" name="surgery.id" id="specimenSurgeryIdInput" value="${surgery.surgery.id}"/>
    </li>
    <li class="specimenProcedureLi">
        <%--<label class="surgeryDateLabel">Procedure: </label>--%>
        <%--<span id="specimenProcedureSpan" class="nonEdit">${surgery.surgery.procedureName}</span>--%>
        <%--<input class="edit hidden small" name="surgery.procedureName" id="specimenProcedureInput" value="${surgery.surgery.procedureName}"/>--%>
    </li>
    <li class="specimenSurgeonLi">
        <label class="surgeryDateLabel">Surgeon: </label>
        <span id="specimenSurgeonSpan" class="nonEdit">${surgery.surgery.surgeon}</span>
        <input class="edit hidden mini" name="surgery.surgeon" id="specimenSurgeonInput" value="${surgery.surgery.surgeon}"/>
    </li>
    <li class="specimenStartLi">
        <label class="surgeryDateLabel">Start Time: </label>
        <span id="specimenStartSpan" class="nonEdit">${surgery.surgery.timeStart}</span>
        <input class="edit hidden tiny" name="surgery.timeStart" id="specimenStartInput" value="${surgery.surgery.timeStart}"/>
    </li>
    <li class="specimenEndLi">
        <label class="surgeryDateLabel">End Time: </label>
        <span id="specimenEndSpan" class="nonEdit">${surgery.surgery.timeEnd}</span>
        <input class="edit hidden tiny" name="surgery.timeEnd" id="specimenEndInput" value="${surgery.surgery.timeEnd}"/>
    </li>
    <li class="specimenDateDt">
        <label class="surgeryDateLabel">Surgery Date: </label>
        <fmt:formatDate value="${surgery.surgery.surgeryDate}" var="surgeryDate" pattern="MM/dd/yyyy"/>
        <span id="specimenDateSpan" class="nonEdit">${surgeryDate}</span>
        <input class="edit hidden mini" name="surgery.surgeryDate" id="specimenDateInput" value="${surgeryDate}"/>
    </li>
    <li class="specimenAnesthesiaTypeLi">
        <label class="surgeryDateLabel">Anesthesia Type: </label>
        <span id="specimenAnesthesiaTypeSpan" class="nonEdit">${surgery.surgery.anesthesiaType.medicine}</span>
        <select title="anesthesiaTypeSelect" id="anesthesiaTypeSelect" name="surgery.anesthesiaType" class="small hidden edit">
            <c:forEach items="${anesthesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.surgery.anesthesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </li>
    <li class="specimenAnesthesiaDoseLi">
        <label class="surgeryDateLabel">Anesthesia Dose: </label>
        <span id="specimenAnesthesiaDoseSpan" class="nonEdit">${surgery.surgery.anesthesiaDosage}</span>
        <input class="edit hidden mini" name="surgery.anesthesiaDosage" id="specimenAnesthesiaDoseInput" value="${surgery.surgery.anesthesiaDosage}"/>
    </li>
    <li class="specimenAnalgesiaTypeLi">
        <label class="surgeryDateLabel">Analgesia Type: </label>
        <span id="specimenAnalgesiaTypeSpan" class="nonEdit">${surgery.surgery.analgesiaType.medicine}</span>
        <select title="analgesiaTypeSelect" id="analgesiaTypeSelect" name="surgery.analgesiaType" class="small hidden edit">
            <c:forEach items="${analgesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.surgery.analgesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </li>
    <li class="specimenAnalgesiaDoseLi">
        <label class="surgeryDateLabel">Analgesia Dose: </label>
        <span id="specimenAnalgesiaDoseSpan" class="nonEdit">${surgery.surgery.analgesiaDose}</span>
        <input class="edit hidden mini" name="surgery.analgesiaDose" id="specimenAnalgesiaDoseInput" value="${surgery.surgery.analgesiaDose}"/>
    </li>
    <li class="specimenNotesLi">
        <label class="surgeryDateLabel">Notes: </label>
        <span id="specimenNotesSpan" class="nonEdit">${surgery.surgery.freeText}</span>
        <input class="edit hidden" name="surgery.freeText" id="specimenNotesInput" value="${surgery.surgery.freeText}"/>
    </li>
</ul>