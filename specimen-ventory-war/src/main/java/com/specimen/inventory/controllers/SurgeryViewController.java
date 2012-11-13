package com.specimen.inventory.controllers;

import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.service.SpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

/**
 * user: ryan.moore
 * date: 11/12/12
 */
@Controller
public class SurgeryViewController {

    @Autowired
    private SpecimenService specimenService;

    @RequestMapping(value = "/surgeryList", method = RequestMethod.GET)
    private String getSurgeryView(ModelMap map) {

        Set<Specimen> specimenSet = specimenService.getAllSpecimens();

        map.addAttribute("specimenSet", specimenSet);
        return "surgeryList";
    }
}
