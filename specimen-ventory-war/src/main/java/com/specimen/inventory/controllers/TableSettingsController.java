package com.specimen.inventory.controllers;

import com.specimen.inventory.controllers.model.TableSettingsFormBean;
import com.specimen.inventory.model.TableColumnDefinition;
import com.specimen.inventory.service.TableColumnDefinitionService;
import com.specimen.inventory.service.exception.TableColumnDefinitionException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/27/13
 */
@Controller
public class TableSettingsController {


    private static final Logger logger = Logger.getLogger(TableSettingsController.class);

    private static final String TABLE_SETTINGS_FETCH_ERROR_MSG = "An error occurred fetching TableColumnDefinitions.";
    @Autowired
    private TableColumnDefinitionService tableColumnDefinitionService;

    @RequestMapping(value = "/tableSettings", method = RequestMethod.GET)
    public String getSurgeryView(ModelMap map) {

        List<TableColumnDefinition> tableColumnDefinitionList = null;

        try {
            tableColumnDefinitionList = tableColumnDefinitionService.getAllTableColumnDefinitions();
        } catch (TableColumnDefinitionException tcde) {
            logger.error("An error occurred while fetching TableColumnDefinitions.", tcde);
            map.addAttribute("errorMessage", TABLE_SETTINGS_FETCH_ERROR_MSG);
            return "error";
        }

        map.addAttribute("tableColumnDefinition", new TableSettingsFormBean(tableColumnDefinitionList));
        return "surgeryDetails";
    }
}
