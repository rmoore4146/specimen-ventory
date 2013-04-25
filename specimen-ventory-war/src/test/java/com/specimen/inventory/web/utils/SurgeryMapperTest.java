package com.specimen.inventory.web.utils;

import com.specimen.inventory.controllers.model.SurgeryFormBean;
import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.model.SurgeryType;
import junit.framework.Assert;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.Date;

/**
 * user: ryan.moore@sparcedge.com
 * date: 4/24/13
 */
public class SurgeryMapperTest {

    @Test
    public void testMapSurgeryToSurgeryFormBean() throws Exception {
        SurgeryFormBean dest = SurgeryMapper.mapSurgeryToSurgeryFormBean(getHeadSurgery());
        Assert.assertNotNull(dest);
    }

    private Surgery getHeadSurgery() {
        Surgery surgery = new Surgery();
        surgery.setAnalgesiaDose("23G");
        surgery.setAnalgesiaType(AnalgesiaType.KETOPROFEN);
        surgery.setAnesthesiaDosage("1234G");
        surgery.setAnesthesiaType(AnesthesiaType.CHLORAL_HYDRATE);
        surgery.setFreeText("blah blah blah");
        surgery.getSurgeryTypes().add(SurgeryType.CANNULA_SURGERY);
        surgery.getSurgeryTypes().add(SurgeryType.OPTRODE_SURGERY);
        surgery.getProcedures().add("Head surgery 7");
        surgery.getProcedures().add("Head surgery 6");
        Specimen specimen = new Specimen();
        specimen.getSurgeryList().add(surgery);
        specimen.setAnimalUUID("R201");
        surgery.setSpecimen(specimen);
        surgery.setSpecimenWeight("14G");
        surgery.setSurgeon("Courtney2");
        surgery.setSurgeryDate(new Date());
        surgery.setTimeEnd("1");
        surgery.setTimeStart("1");
        return surgery;
    }
}
