package com.specimen.inventory.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class SurgeryForm implements Serializable {

    private long id;
    private Date surgeryDate;
    private String animalUUID;
    private String timeStart;
    private String timeEnd;
    private String surgeon;
    private String procedureName;
    private AnesthesiaType anesthesiaType;
    private String anesthesiaDosage;
    private AnalgesiaType analgesiaType;
    private String analgesiaDose;
    private List<PostOperativeBehavior> postOperativeBehaviorList;
    private String firstDayAfterSurgeryDescription;
    private String secondDayAfterSurgeryDescription;
    private String thirdDayAfterSurgeryDescription;
    private String specimenWeight;
    private String freeText;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public String getSpecimenWeight() {
        return specimenWeight;
    }

    public void setSpecimenWeight(String specimenWeight) {
        this.specimenWeight = specimenWeight;
    }

    public Date getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(Date surgeryDate) {
        this.surgeryDate = surgeryDate;
    }

    public String getAnimalUUID() {
        return animalUUID;
    }

    public void setAnimalUUID(String animalUUID) {
        this.animalUUID = animalUUID;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getSurgeon() {
        return surgeon;
    }

    public void setSurgeon(String surgeon) {
        this.surgeon = surgeon;
    }

    public String getProcedureName() {
        return procedureName;
    }

    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    public AnesthesiaType getAnesthesiaType() {
        return anesthesiaType;
    }

    public void setAnesthesiaType(AnesthesiaType anesthesiaType) {
        this.anesthesiaType = anesthesiaType;
    }

    public String getAnesthesiaDosage() {
        return anesthesiaDosage;
    }

    public void setAnesthesiaDosage(String anesthesiaDosage) {
        this.anesthesiaDosage = anesthesiaDosage;
    }

    public AnalgesiaType getAnalgesiaType() {
        return analgesiaType;
    }

    public void setAnalgesiaType(AnalgesiaType analgesiaType) {
        this.analgesiaType = analgesiaType;
    }

    public String getAnalgesiaDose() {
        return analgesiaDose;
    }

    public void setAnalgesiaDose(String analgesiaDose) {
        this.analgesiaDose = analgesiaDose;
    }

    public List<PostOperativeBehavior> getPostOperativeBehaviorList() {

        if (postOperativeBehaviorList == null) {
            this.postOperativeBehaviorList = new ArrayList<PostOperativeBehavior>();
        }
        return this.postOperativeBehaviorList;
    }

    public String getFirstDayAfterSurgeryDescription() {
        return firstDayAfterSurgeryDescription;
    }

    public void setFirstDayAfterSurgeryDescription(String firstDayAfterSurgeryDescription) {
        this.firstDayAfterSurgeryDescription = firstDayAfterSurgeryDescription;
    }

    public String getSecondDayAfterSurgeryDescription() {
        return secondDayAfterSurgeryDescription;
    }

    public void setSecondDayAfterSurgeryDescription(String secondDayAfterSurgeryDescription) {
        this.secondDayAfterSurgeryDescription = secondDayAfterSurgeryDescription;
    }

    public String getThirdDayAfterSurgeryDescription() {
        return thirdDayAfterSurgeryDescription;
    }

    public void setThirdDayAfterSurgeryDescription(String thirdDayAfterSurgeryDescription) {
        this.thirdDayAfterSurgeryDescription = thirdDayAfterSurgeryDescription;
    }
}