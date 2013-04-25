<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.specimen.inventory.model.AnesthesiaType" %>
<%@ page import="com.specimen.inventory.model.AnalgesiaType" %>
<%@ page import="com.specimen.inventory.model.Surgery" %>
<%@ page import="com.specimen.inventory.model.SurgeryType" %>

<ul class="formFields col1">
    <li class="specimenAnimalIdLi">
        <label class="surgeryDateLabel">Specimen UUID: </label>
        <input class="edit medium"  name="surgery.specimen.animalUUID" id="specimenAnimalIdInput" value="${surgery.surgery.specimen.animalUUID}"/>
    </li>
    <li class="specimenSurgeryTypeLi">
        <label class="surgeryTypeLabel">Surgery Type: </label>
        <ul>
            <c:forEach items="${surgeryTypes}" var="value" varStatus="typeIndex">
                <li>
                    <input type="checkbox"  name="surgeryTypes[${typeIndex.index}]" value="${value}" title=""
                    <c:forEach items="${surgery.surgeryTypes}" var="type">
                        <c:if test="${type == value}">checked="checked"</c:if>
                    </c:forEach>
                    />${value.surgeryType}
                </li>
            </c:forEach>

        </ul>
    </li>
    <li class="specimenProcedureLi">
        <label class="surgeryDateLabel">Procedures: </label><span>(comma delimited)</span>
        <input class="edit xlarge"  name="procedures" id="specimenProcedureInput" value="${surgery.procedures}"/>
    </li>
    <li class="specimenSurgeonLi">
        <label class="surgeryDateLabel">Surgeon: </label>
        <input class="edit medium"  name="surgery.surgeon" id="specimenSurgeonInput" value="${surgery.surgery.surgeon}"/>
    </li>
    <li class="specimenStartLi">
        <label class="surgeryDateLabel">Start Time: </label>
        <input class="edit medium"  name="surgery.timeStart" id="specimenStartInput" value="${surgery.surgery.timeStart}"/>
    </li>
    <li class="specimenEndLi">
        <label class="surgeryDateLabel">End Time: </label>
        <input class="edit medium"  name="surgery.timeEnd" id="specimenEndInput" value="${surgery.surgery.timeEnd}"/>
    </li>
    <li class="specimenDateDt">
        <fmt:formatDate value="${surgery.surgery.surgeryDate}" var="surgeryDate" pattern="MM/dd/yyyy"/>
        <label class="surgeryDateLabel">Surgery Date: </label>
        <input class="edit medium"  name="surgery.surgeryDate" id="specimenDateInput" value="${surgeryDate}"/>
    </li>
    <li class="specimenAnesthesiaTypeLi">
        <label class="surgeryDateLabel">Anesthesia Type: </label>
        <select title="anesthesiaTypeSelect" id="anesthesiaTypeSelect"  name="surgery.anesthesiaType" class="medium edit">
            <option value=""> </option>
            <c:forEach items="${anesthesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.surgery.anesthesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </li>
    <li class="specimenAnesthesiaDoseLi">
        <label class="surgeryDateLabel">Anesthesia Dose: </label>
        <input class="edit medium"  name="surgery.anesthesiaDosage" id="specimenAnesthesiaDoseInput" value="${surgery.surgery.anesthesiaDosage}"/>
    </li>
    <li class="specimenAnalgesiaTypeLi">
        <label class="surgeryDateLabel">Analgesia Type: </label>
        <select title="analgesiaTypeSelect" id="analgesiaTypeSelect"  name="surgery.analgesiaType" class="medium edit">
            <option value=""> </option>
            <c:forEach items="${analgesiaTypes}" var="value">
                <option value="${value}" <c:if test="${value == surgery.surgery.analgesiaType}">selected="selected"</c:if>>${value.medicine}</option>
            </c:forEach>
        </select>
    </li>
    <li class="specimenAnalgesiaDoseLi">
        <label class="surgeryDateLabel">Analgesia Dose: </label>
        <input class="edit medium"  name="surgery.analgesiaDose" id="specimenAnalgesiaDoseInput" value="${surgery.surgery.analgesiaDose}"/>
    </li>
    <li class="specimenNotesLi">
        <label class="surgeryDateLabel">Notes: </label>
        <input class="edit xlarge"  name="surgery.freeText" id="specimenNotesInput" value="${surgery.surgery.freeText}"/>
    </li>
</ul>