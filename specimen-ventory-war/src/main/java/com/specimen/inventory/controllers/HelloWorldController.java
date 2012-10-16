package com.specimen.inventory.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String helloGet(ModelMap map, HttpServletRequest request) {

        String param = request.getParameter("name");

        if (param == null) {
            map.put("name", "Blah blah blah");
        } else {
            map.put("name", param);
        }

        return "helloWorld";
    }
}
