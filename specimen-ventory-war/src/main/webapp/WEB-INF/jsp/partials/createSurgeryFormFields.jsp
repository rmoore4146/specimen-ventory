<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.specimen.inventory.model.AnesthesiaType" %>
<%@ page import="com.specimen.inventory.model.AnalgesiaType" %>
<%@ page import="com.specimen.inventory.model.Surgery" %>

<ul class="formFields col1">
    <li class="specimenAnimalIdLi">
        <label class="surgeryDateLabel">Specimen UUID: </label>
        <input class="edit tiny" name="specimen.animalUUID" id="specimenAnimalIdInput" value="${surgery.specimen.animalUUID}"/>
    </li>
    <li class="specimenSurgeryTypeLi">
        <label class="surgeryTypeLabel">Surgery Type: </label>
        <select title="surgeryTypeSelect" id="surgeryTypeSelect" name="surgeryType" class="small edit">
            <option value=""> </option>
            <c:forEach items="${surgeryTypes}" var="value">
                <option value="${value}">${value.surgeryType}</option>
            </c:forEach>
        </select>
    </li>
    <li class="specimenProcedureLi">
        <label class="surgeryDateLabel">Procedure: </label>
        <input class="edit small" name="procedureName" id="specimenProcedureInput" value="${surgery.procedureName}"/>
    </li>
    <li class="specimenSurgeonLi">
        <label class="surgeryDateLabel">Surgeon: </label>
        <input class="edit mini" name="surgeon" id="specimenSurgeonInput" value="${surgery.surgeon}"/>
    </li>
    <li class="specimenStartLi">
        <label class="surgeryDateLabel">Start Time: </label>
        <input class="edit tiny" name="timeStart" id="specimenStartInput" value="${surgery.timeStart}"/>
    </li>
    <li class="specimenEndLi">
        <label class="surgeryDateLabel">End Time: </label>
        <input class="edit tiny" name="timeEnd" id="specimenEndInput" value="${surgery.timeEnd}"/>
    </li>
    <li class="specimenDateDt">
        <label class="surgeryDateLabel">Surgery Date: </label>
        <input class="edit mini" name="surgeryDate" id="specimenDateInput" value="${surgeryDate}"/>
    </li>
    <li class="specimenAnesthesiaTypeLi">
        <label class="surgeryDateLabel">Anesthesia Type: </label>
        <select title="anesthesiaTypeSelect" id="anesthesiaTypeSelect" name="anesthesiaType" class="small edit">
            <option value=""> </option>
            <c:forEach items="${anesthesiaTypes}" var="value">
                <option value="${value}">${value.medicine}</option>
            </c:forEach>
        </select>
    </li>
    <li class="specimenAnesthesiaDoseLi">
        <label class="surgeryDateLabel">Anesthesia Dose: </label>
        <input class="edit mini" name="anesthesiaDosage" id="specimenAnesthesiaDoseInput" value="${surgery.anesthesiaDosage}"/>
    </li>
    <li class="specimenAnalgesiaTypeLi">
        <label class="surgeryDateLabel">Analgesia Type: </label>
        <select title="analgesiaTypeSelect" id="analgesiaTypeSelect" name="analgesiaType" class="small edit">
            <option value=""> </option>
            <c:forEach items="${analgesiaTypes}" var="value">
                <option value="${value}">${value.medicine}</option>
            </c:forEach>
        </select>
    </li>
    <li class="specimenAnalgesiaDoseLi">
        <label class="surgeryDateLabel">Analgesia Dose: </label>
        <input class="edit mini" name="analgesiaDose" id="specimenAnalgesiaDoseInput" value="${surgery.analgesiaDose}"/>
    </li>
    <li class="specimenNotesLi">
        <label class="surgeryDateLabel">Notes: </label>
        <input class="edit" name="freeText" id="specimenNotesInput" value="${surgery.freeText}"/>
    </li>
</ul>