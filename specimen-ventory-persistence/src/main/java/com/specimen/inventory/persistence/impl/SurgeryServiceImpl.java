package com.specimen.inventory.persistence.impl;

import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.HeadSurgeryForm;
import com.specimen.inventory.model.SurgeryForm;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SpecimenServiceException;\

import java.util.Date;

/**
 * user: ryan.moore
 * date: 10/22/12
 */
public class SurgeryServiceImpl implements SurgeryService {



    @Resource(name="sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public SurgeryForm createSurgery(SurgeryForm surgery) throws SpecimenServiceException {
        return getHeadSurgeryFormMock();
    }

    @Override
    public SurgeryForm fetchSurgery(long id) throws SpecimenServiceException {
        return getHeadSurgeryFormMock();
    }

    private HeadSurgeryForm getHeadSurgeryFormMock() {
        HeadSurgeryForm form = new HeadSurgeryForm();
        form.setFreeText("blah");
        form.setId(123L);
        form.setTimeEnd("4PM");
        form.setAnalgesiaType(AnalgesiaType.KETOPROFEN);
        form.setSurgeryDate(new Date());
        form.setSurgeon("Courtney");
        return form;
    }
}
