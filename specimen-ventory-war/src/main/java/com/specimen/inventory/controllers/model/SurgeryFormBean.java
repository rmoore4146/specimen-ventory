package com.specimen.inventory.controllers.model;

import com.specimen.inventory.model.PostOperativeBehavior;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.model.SurgeryType;

import java.util.ArrayList;
import java.util.List;

/**
 * user: ryan.moore
 * date: 10/15/12
 */
public class SurgeryFormBean {

    private Surgery surgery;
    private List<PostOperativeBehavior> postOperativeBehaviorList;
    private List<SurgeryType> surgeryTypes;
    private List<String> procedures;

    public SurgeryFormBean(Surgery surgery) {
        this.postOperativeBehaviorList = new ArrayList<PostOperativeBehavior>(surgery.getPostOperativeBehaviorList());
        this.surgeryTypes = new ArrayList<SurgeryType>(surgery.getSurgeryTypes());
        this.procedures = new ArrayList<String>(surgery.getProcedures());
        this.surgery = surgery;
    }

    public SurgeryFormBean() {
        this.surgery = new Surgery();
    }

    public Surgery getSurgery() {
        return surgery;
    }

    public void setSurgery(Surgery surgery) {
        this.surgery = surgery;
    }

    public Surgery getTransformedSurgery() {
        this.surgery.getSurgeryTypes().addAll(this.getSurgeryTypes());
        this.surgery.getProcedures().addAll(this.getProcedures());
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

    public List<String> getProcedures() {
        if (this.procedures == null) {
            this.procedures = new ArrayList<String>();
        }
        return procedures;
    }

    public void setProcedures(List<String> procedures) {
        this.procedures = procedures;
    }
}