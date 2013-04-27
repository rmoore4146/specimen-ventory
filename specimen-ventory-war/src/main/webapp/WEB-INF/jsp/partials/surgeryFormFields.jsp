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

<div class="control-group specimenUUIDDiv">
    <label class="surgeryDateLabel control-label" for="specimenAnimalIdInput">Specimen UUID: </label>
    <input class="edit medium controls"  name="surgery.specimen.animalUUID" id="specimenAnimalIdInput" value="${surgery.surgery.specimen.animalUUID}"/>
</div>
<div class="control-group specimenSurgeryTypeDiv">
    <p class="pull-left control-label">Surgery Type:</p>
    <div class="controls span2">
        <c:forEach items="${surgeryTypes}" var="value" varStatus="typeIndex">
            <label class="checkbox">
                <input type="checkbox"  name="surgeryTypes[${typeIndex.index}]" value="${value}" title=""
                    <c:forEach items="${surgery.surgeryTypes}" var="type">
                        <c:if test="${type == value}">checked="checked"</c:if>
                    </c:forEach>
                    />${value.surgeryType}
            </label>
        </c:forEach>
    </div>
</div>

<div class="control-group specimenProcedureLi">
    <label class="control-label surgeryDateLabel">Procedures: </label>
    <input class="controls edit xlarge"  name="procedures" id="specimenProcedureInput" value="${surgery.procedures}"/>
</div>
<div class="control-group specimenSurgeonLi">
    <label class="control-label surgeryDateLabel">Surgeon: </label>
    <input class="controls edit medium"  name="surgery.surgeon" id="specimenSurgeonInput" value="${surgery.surgery.surgeon}"/>
</div>
<div class="control-group specimenStartLi">
    <label class="control-label surgeryDateLabel">Start Time: </label>
    <input class="controls edit medium"  name="surgery.timeStart" id="specimenStartInput" value="${surgery.surgery.timeStart}"/>
</div>
<div class="control-group specimenEndLi">
    <label class="control-label surgeryDateLabel">End Time: </label>
    <input class="controls edit medium"  name="surgery.timeEnd" id="specimenEndInput" value="${surgery.surgery.timeEnd}"/>
</div>
<div class="control-group specimenDateDt">
    <fmt:formatDate value="${surgery.surgery.surgeryDate}" var="surgeryDate" pattern="MM/dd/yyyy"/>
    <label class="control-label surgeryDateLabel">Surgery Date: </label>
    <input class="controls edit medium"  name="surgery.surgeryDate" id="specimenDateInput" value="${surgeryDate}"/>
</div>
<div class="control-group specimenAnesthesiaTypeLi">
    <label class="control-label surgeryDateLabel">Anesthesia Type: </label>
    <select title="anesthesiaTypeSelect" id="anesthesiaTypeSelect"  name="surgery.anesthesiaType" class="controls medium edit">
        <option value=""> </option>
        <c:forEach items="${anesthesiaTypes}" var="value">
            <option value="${value}" <c:if test="${value == surgery.surgery.anesthesiaType}">selected="selected"</c:if>>${value.medicine}</option>
        </c:forEach>
    </select>
</div>
<div class="control-group specimenAnesthesiaDoseLi">
    <label class="control-label surgeryDateLabel">Anesthesia Dose: </label>
    <input class="controls edit medium"  name="surgery.anesthesiaDosage" id="specimenAnesthesiaDoseInput" value="${surgery.surgery.anesthesiaDosage}"/>
</div>
<div class="control-group specimenAnalgesiaTypeLi">
    <label class="control-label surgeryDateLabel">Analgesia Type: </label>
    <select title="analgesiaTypeSelect" id="analgesiaTypeSelect"  name="surgery.analgesiaType" class="controls medium edit">
        <option value=""> </option>
        <c:forEach items="${analgesiaTypes}" var="value">
            <option value="${value}" <c:if test="${value == surgery.surgery.analgesiaType}">selected="selected"</c:if>>${value.medicine}</option>
        </c:forEach>
    </select>
</div>
<div class="control-group specimenAnalgesiaDoseLi">
    <label class="control-label surgeryDateLabel">Analgesia Dose: </label>
    <input class="controls edit medium"  name="surgery.analgesiaDose" id="specimenAnalgesiaDoseInput" value="${surgery.surgery.analgesiaDose}"/>
</div>
<div class="control-group specimenNotesLi">
    <label class="control-label surgeryDateLabel">Notes: </label>
    <input class="controls edit xlarge"  name="surgery.freeText" id="specimenNotesInput" value="${surgery.surgery.freeText}"/>
</div>