package com.specimen.inventory.model;

import java.io.Serializable;
import java.util.List;

/**
 * user: ryan.moore
 * date: 10/24/12
 */
public class Specimen implements Serializable {

    private List<Surgery> surgeryList;
    private Long id;
    private String animalUUID;

    public List<Surgery> getSurgeryList() {
        return surgeryList;
    }

    public void setSurgeryList(List<Surgery> surgeryList) {
        this.surgeryList = surgeryList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnimalUUID() {
        return animalUUID;
    }

    public void setAnimalUUID(String animalUUID) {
        this.animalUUID = animalUUID;
    }
}
