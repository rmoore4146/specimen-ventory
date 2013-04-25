package com.specimen.inventory.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class Surgery implements Serializable {

    private long id;
    private Date surgeryDate;
    private String timeStart;
    private String timeEnd;
    private String surgeon;
    private AnesthesiaType anesthesiaType;
    private String anesthesiaDosage;
    private AnalgesiaType analgesiaType;
    private String analgesiaDose;
    private Set<PostOperativeBehavior> postOperativeBehaviorList;
    private String firstDayAfterSurgeryDescription;
    private String secondDayAfterSurgeryDescription;
    private String thirdDayAfterSurgeryDescription;
    private String specimenWeight;
    private String freeText;
    private Specimen specimen;
    private Set<SurgeryType> surgeryTypes;
    private String surgeryDescription;
    private Set<String> procedures;
    private Date cutDate;
    private String histologyNotes;
    private Date perfusionDate;
    private String perfusionProcedure;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getSurgeryDate() {
        return surgeryDate;
    }

    public void setSurgeryDate(Date surgeryDate) {
        this.surgeryDate = surgeryDate;
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

    public Set<PostOperativeBehavior> getPostOperativeBehaviorList() {
        if (postOperativeBehaviorList == null) {
            postOperativeBehaviorList = new HashSet<PostOperativeBehavior>();
        }
        return postOperativeBehaviorList;
    }

    public void setPostOperativeBehaviorList(Set<PostOperativeBehavior> postOperativeBehaviorList) {
        this.postOperativeBehaviorList = postOperativeBehaviorList;
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

    public String getSpecimenWeight() {
        return specimenWeight;
    }

    public void setSpecimenWeight(String specimenWeight) {
        this.specimenWeight = specimenWeight;
    }

    public String getFreeText() {
        return freeText;
    }

    public void setFreeText(String freeText) {
        this.freeText = freeText;
    }

    public Specimen getSpecimen() {
        return specimen;
    }

    public void setSpecimen(Specimen specimen) {
        this.specimen = specimen;
    }

    public Set<SurgeryType> getSurgeryTypes() {
        if (surgeryTypes == null) {
            surgeryTypes = new HashSet<SurgeryType>();
        }
        return surgeryTypes;
    }

    public void setSurgeryTypes(Set<SurgeryType> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public String getSurgeryDescription() {
        return surgeryDescription;
    }

    public void setSurgeryDescription(String surgeryDescription) {
        this.surgeryDescription = surgeryDescription;
    }

    public Set<String> getProcedures() {
        if (procedures == null) {
            procedures = new HashSet<String>();
        }
        return procedures;
    }

    public void setProcedures(Set<String> procedures) {
        this.procedures = procedures;
    }

    public Date getCutDate() {
        return cutDate;
    }

    public void setCutDate(Date cutDate) {
        this.cutDate = cutDate;
    }

    public String getHistologyNotes() {
        return histologyNotes;
    }

    public void setHistologyNotes(String histologyNotes) {
        this.histologyNotes = histologyNotes;
    }

    public Date getPerfusionDate() {
        return perfusionDate;
    }

    public void setPerfusionDate(Date perfusionDate) {
        this.perfusionDate = perfusionDate;
    }

    public String getPerfusionProcedure() {
        return perfusionProcedure;
    }

    public void setPerfusionProcedure(String perfusionProcedure) {
        this.perfusionProcedure = perfusionProcedure;
    }
}