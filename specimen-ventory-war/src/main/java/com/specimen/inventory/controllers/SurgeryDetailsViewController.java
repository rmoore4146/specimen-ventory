package com.specimen.inventory.controllers;

import com.specimen.inventory.controllers.model.SurgeryFormBean;
import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.model.SurgeryType;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
    private static final String SURGERY_UPDATE_ERROR_MSG = "An error occurred while updating surgery.";


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
            map.addAttribute("analgesiaTypes", AnalgesiaType.values());
            map.addAttribute("anesthesiaTypes", AnesthesiaType.values());
            map.addAttribute("surgeryTypes", SurgeryType.values());
            map.addAttribute("surgery", new SurgeryFormBean(surgery));
            return "surgeryDetails";

        } else {
            logger.error("Surgery ID passed to Surgery Details page was null");
            map.addAttribute("errorMessage", SURGERY_GET_ERROR_MSG);
            return "error";
        }
    }


    @RequestMapping(value = "surgeryDetails/updateSurgeryDetails", method = RequestMethod.POST)
    public ModelAndView updateSurgery(@ModelAttribute SurgeryFormBean surgery) {

        Surgery actualSurgery = surgery.getTransformedSurgery();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("partials/surgeryFormFields");

        FormUtil.fixSurgeryTypes(actualSurgery);

        try{
            Surgery updatedSurgery = surgeryService.updateSurgery(actualSurgery);
            modelAndView.addObject("surgery", new SurgeryFormBean(updatedSurgery));
            modelAndView.addObject("analgesiaTypes", AnalgesiaType.values());
            modelAndView.addObject("anesthesiaTypes", AnesthesiaType.values());
        } catch (SurgeryServiceException sse) {
            logger.error(SURGERY_UPDATE_ERROR_MSG + " Id -" + actualSurgery.getId(), sse);
            modelAndView.setViewName("error");
            modelAndView.addObject("errorMessage", SURGERY_UPDATE_ERROR_MSG);
        }

        return modelAndView;
    }
}
