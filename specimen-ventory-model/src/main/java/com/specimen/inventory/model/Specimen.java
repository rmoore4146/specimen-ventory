package com.specimen.inventory.model;

import java.io.Serializable;

/**
 * user: ryan.moore
 * date: 10/24/12
 */
public class Specimen implements Serializable {

    private Long id;
    private String animalUUID;

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
    }}
