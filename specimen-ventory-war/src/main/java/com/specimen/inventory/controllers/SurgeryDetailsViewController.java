package com.specimen.inventory.controllers;

import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SurgeryServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * user: ryan.moore
 * date: 11/12/12
 */
@Controller
public class SurgeryDetailsViewController {

    private static final Logger logger = Logger.getLogger(SurgeryDetailsViewController.class);
    private static final String SURGERY_GET_ERROR_MSG = "An error occurred while updating surgery.";

//    @Autowired
//    private SpecimenService specimenService;

    @Autowired
    private SurgeryService surgeryService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        dateFormatter.setLenient(false);

        // true passed to CustomDateEditor constructor means convert empty String to null
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
    }

    @RequestMapping(value = "/surgeryDetails/{surgeryId}", method = RequestMethod.GET)
    public String getSurgeryView(@PathVariable String surgeryId, ModelMap map) {

        //get long value in a safe way, return error page otherwise
        Long id = Long.valueOf(surgeryId);

        if (id != null) {

            Surgery surgery = null;
            try {
                surgery = surgeryService.getSurgery(id);
            } catch (SurgeryServiceException e) {
                logger.error("An error occurred while fetching surgery.", e);
                map.addAttribute("errorMessage", SURGERY_GET_ERROR_MSG);
                return "error";
            }

            map.addAttribute("surgery", surgery);
            return "surgeryDetails";

        } else {

            map.addAttribute("errorMessage", SURGERY_GET_ERROR_MSG);
            return "error";
        }
    }
}
