package com.specimen.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * user: ryan.moore
 * date: 10/16/12
 */
@Controller
public class SurgeryRequestController {

    @RequestMapping(method= RequestMethod.POST, value="/createSurgeryEntry",
    headers="Accept=application/xml, application/json")
    public String createSurgeryEntry(@RequestBody String body) {

        //TODO implement createSurgery method
        return "createSurgeryResponse";
    }
}
