package com.specimen.inventory.controllers;

import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.HeadSurgery;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.SpecimenService;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SurgeryServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * user: ryan.moore
 * date: 11/12/12
 */
@Controller
public class SurgeryListViewController {

    private static final Logger logger = Logger.getLogger(SurgeryListViewController.class);
    private static final String SURGERY_UPDATE_MSG = "An error occurred while updating surgery.";

    @Autowired
    private SpecimenService specimenService;

    @Autowired
    private SurgeryService surgeryService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
        dateFormatter.setLenient(false);

        // true passed to CustomDateEditor constructor means convert empty String to null
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, true));
    }

    @RequestMapping(value = "/surgeryList", method = RequestMethod.GET)
    public String getSurgeryView(ModelMap map) {

        Set<Surgery> surgerySet = surgeryService.listSurgeries();

        map.addAttribute("analgesiaTypes", AnalgesiaType.values());
        map.addAttribute("anesthesiaTypes", AnesthesiaType.values());
        map.addAttribute("surgerySet", surgerySet);
        return "surgeryList";
    }

    @RequestMapping(value = "/updateSurgery", method = RequestMethod.POST)
    public ModelAndView updateSurgery(@ModelAttribute HeadSurgery surgery) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("partials/surgeryRow");

        try{
            Surgery updatedSurgery = surgeryService.updateSurgery(surgery);
            modelAndView.addObject("surgery", updatedSurgery);
            modelAndView.addObject("analgesiaTypes", AnalgesiaType.values());
            modelAndView.addObject("anesthesiaTypes", AnesthesiaType.values());
        } catch (SurgeryServiceException sse) {
            logger.error(SURGERY_UPDATE_MSG + " Id -" + surgery.getId(), sse);
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", SURGERY_UPDATE_MSG);
        }

        return modelAndView;
    }

    @RequestMapping(value = "/deleteSurgery", method = RequestMethod.POST)
    public ModelAndView deleteSurgery(@ModelAttribute HeadSurgery surgery) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("partials/surgeryRow");

        try{
            surgeryService.deleteSurgery(surgery.getId());
            modelAndView.addObject("surgery", surgery);
        } catch (SurgeryServiceException sse) {
            logger.error(SURGERY_UPDATE_MSG + " Id -" + surgery.getId(), sse);
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", SURGERY_UPDATE_MSG);
        }

        return modelAndView;
    }
}
