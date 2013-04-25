package com.specimen.inventory.controllers.model;

import com.specimen.inventory.model.PostOperativeBehavior;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.model.SurgeryType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class SurgeryFormBean {

    private Surgery surgery;
    private List<PostOperativeBehavior> postOperativeBehaviorList;
    private List<SurgeryType> surgeryTypes;
    private String procedures;
    private List<String> procedureList;

    public SurgeryFormBean(Surgery surgery) {
        this.postOperativeBehaviorList = new ArrayList<PostOperativeBehavior>(surgery.getPostOperativeBehaviorList());
        this.surgeryTypes = new ArrayList<SurgeryType>(surgery.getSurgeryTypes());
        this.procedures = toProcedureString(surgery.getProcedures());
        this.procedureList = new ArrayList<String>(surgery.getProcedures());
        this.surgery = surgery;
    }

    public SurgeryFormBean() {
        this.surgery = new Surgery();
    }

    public Surgery getSurgery() {
        return surgery;
    }

    private String toProcedureString(Set<String> procedureStringSet) {

        StringBuilder builder = new StringBuilder();
        Iterator it = procedureStringSet.iterator();
        while(it.hasNext()) {

            builder.append(it.next());
            if (it.hasNext()) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    private Set<String> toProcedureSet(String procedureString) {

        Set<String> procedureSet = new HashSet<String>();
        if (procedureString.contains(", ")) {
            String splitString[] = procedureString.split(", ");
            for(String currentString:splitString) {
                procedureSet.add(currentString);
            }
        }
        return procedureSet;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public Surgery getTransformedSurgery() {
        this.surgery.getSurgeryTypes().addAll(this.getSurgeryTypes());
        this.surgery.getProcedures().addAll(toProcedureSet(getProcedures()));
        this.surgery.getPostOperativeBehaviorList().addAll(this.getPostOperativeBehaviorList());
        return surgery;
    }

    public List<PostOperativeBehavior> getPostOperativeBehaviorList() {
        if (this.postOperativeBehaviorList == null) {
            this.postOperativeBehaviorList = new ArrayList<PostOperativeBehavior>();
        }
        return postOperativeBehaviorList;
    }

    public void setPostOperativeBehaviorList(List<PostOperativeBehavior> postOperativeBehaviorList) {
        this.postOperativeBehaviorList = postOperativeBehaviorList;
    }

    public List<SurgeryType> getSurgeryTypes() {
        if (this.surgeryTypes == null) {
            this.surgeryTypes = new ArrayList<SurgeryType>();
        }
        return surgeryTypes;
    }

    public void setSurgeryTypes(List<SurgeryType> surgeryTypes) {
        this.surgeryTypes = surgeryTypes;
    }

    public String getProcedures() {
        return procedures;
    }

    public void setProcedures(String procedures) {
        this.procedures = procedures;
    }

    public List<String> getProcedureList() {
        if (procedureList == null) {
            procedureList = new ArrayList<String>();
        }
        return procedureList;
    }

    public void setProcedureList(List<String> procedureList) {
        this.procedureList = procedureList;
    }
}