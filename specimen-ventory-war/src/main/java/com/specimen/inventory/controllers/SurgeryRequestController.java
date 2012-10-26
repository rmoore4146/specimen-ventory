package com.specimen.inventory.controllers;

import com.specimen.inventory.model.HeadSurgery;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletResponse;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
@Controller
public class SurgeryRequestController {

    private static final String DATA_FIELD = "data";
    private static final String ERROR_FIELD = "error";

    private static final Logger logger = Logger.getLogger(SurgeryRequestController.class);

    @Autowired
    private View jsonView;

    @Autowired
    SurgeryService surgeryService;

    @RequestMapping(value = {"/rest/surgery/head/"}, method = {RequestMethod.POST})
    public ModelAndView createHeadSurgery(@RequestBody HeadSurgery surgery, HttpServletResponse httpResponse, WebRequest request) {

        HeadSurgery createdSurgery = null;
        logger.info(surgery.toString());

        try {
            createdSurgery = (HeadSurgery) surgeryService.createSurgery(surgery);
        } catch (SpecimenServiceException sse) {
            logger.error(sse);
            return createErrorResponse("Failed createSurgery() operation");
        }

        /* set HTTP response code */
        httpResponse.setStatus(HttpStatus.CREATED.value());

        /* set location of created resource */
        httpResponse.setHeader("Location", request.getContextPath() + "/rest/surgery/head/" + createdSurgery.getId());

        /**
         * Return the view
         */
        return new ModelAndView(jsonView, DATA_FIELD, createdSurgery);
    }

    @RequestMapping(value = {"/rest/surgery/head/{surgeryId}"}, method = {RequestMethod.GET})
    public ModelAndView getHeadSurgery(@PathVariable("surgeryId") String surgeryId) {

        HeadSurgery getSurgery = null;
        Long longSurgeryId = null;
        logger.info("getHeadSurgery() with parameter -" + surgeryId);

        /* validate fund Id parameter */
        if (StringUtils.isNotEmpty(surgeryId) && StringUtils.isNumeric(surgeryId)) {
            longSurgeryId = Long.valueOf(surgeryId);
        } else {
            String message = "Error invoking getHeadSurgery - Invalid surgeryId parameter";
            logger.error(message);
            return createErrorResponse(message);
        }

        try {
            getSurgery = (HeadSurgery) surgeryService.getSurgery(longSurgeryId);
        } catch (SpecimenServiceException sse) {
            logger.error(sse);
            String message = "Error invoking getFund.";
            return createErrorResponse(message);
        }
        /**
         * Return the view
         */
        return new ModelAndView(jsonView, DATA_FIELD, getSurgery);
    }

    private ModelAndView createErrorResponse(String message) {
        return new ModelAndView(jsonView, ERROR_FIELD, message);
    }

    public void setSurgeryService(SurgeryService fundService_p) {
        surgeryService = fundService_p;
    }

    public void setJsonView(View view) {
        jsonView = view;
    }

}