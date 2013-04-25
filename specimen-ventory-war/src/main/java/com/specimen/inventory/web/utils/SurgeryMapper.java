package com.specimen.inventory.web.utils;

import com.specimen.inventory.controllers.model.SurgeryFormBean;
import com.specimen.inventory.model.Surgery;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/24/13
 */
public class SurgeryMapper {

    private static final Logger logger = Logger.getLogger(SurgeryMapper.class);

    public static SurgeryFormBean mapSurgeryToSurgeryFormBean(Surgery surgery) {

        SurgeryFormBean bean = new SurgeryFormBean();
        java.util.Date defaultValue = null;
        DateConverter converter = new DateConverter(defaultValue);
        ConvertUtils.register(converter, java.util.Date.class);

        try {
            BeanUtils.copyProperties(bean, surgery);
        } catch (IllegalAccessException e) {
            logger.error("unable to map to SurgeryFormBean", e);
        } catch (InvocationTargetException e) {
            logger.error("unable to map to SurgeryFormBean", e);
        }
        return bean;
    }
}
