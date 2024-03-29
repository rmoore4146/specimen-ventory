package com.specimen.inventory.controllers;

import com.specimen.inventory.controllers.model.SurgeryFormBean;
import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.model.SurgeryType;
import com.specimen.inventory.service.SpecimenService;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SurgeryServiceException;
import com.specimen.inventory.web.utils.FormUtil;
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
 * date: 12/19/12
 */
@Controller
public class CreateSurgeryViewController {

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

    @RequestMapping(value = "/createSurgery", method = RequestMethod.GET)
    public String getSurgeryView(ModelMap map) {

        Set<Surgery> surgerySet = surgeryService.listSurgeries();

        map.addAttribute("analgesiaTypes", AnalgesiaType.values());
        map.addAttribute("anesthesiaTypes", AnesthesiaType.values());
        map.addAttribute("surgeryTypes", SurgeryType.values());

        return "createSurgery";
    }

    @RequestMapping(value = "/createSurgery", method = RequestMethod.POST)
    public ModelAndView updateSurgery(@ModelAttribute SurgeryFormBean surgery) {

        Surgery internalSurgery = surgery.getTransformedSurgery();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("partials/surgeryRow");

        FormUtil.fixSurgeryTypes(internalSurgery);

        try{
            Surgery updatedSurgery = surgeryService.updateSurgery(internalSurgery);
            modelAndView.addObject("surgery", new SurgeryFormBean(updatedSurgery));
            modelAndView.addObject("analgesiaTypes", AnalgesiaType.values());
            modelAndView.addObject("anesthesiaTypes", AnesthesiaType.values());
        } catch (SurgeryServiceException sse) {
            logger.error(SURGERY_UPDATE_MSG + " Id -" + internalSurgery.getId(), sse);
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", SURGERY_UPDATE_MSG);
        }

        return modelAndView;
    }
}
