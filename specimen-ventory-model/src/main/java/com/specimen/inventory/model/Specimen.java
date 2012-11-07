package com.specimen.inventory.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * user: ryan.moore
 * date: 10/24/12
 */
public class Specimen implements Serializable {

    private Set<Surgery> surgeryList;
    private Long id;
    private String animalUUID;

    public Set<Surgery> getSurgeryList() {
        if (surgeryList == null) {
            surgeryList = new HashSet<Surgery>();
        }
        return surgeryList;
    }

    public void setSurgeryList(Set<Surgery> surgeryList) {
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
