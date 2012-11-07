import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.HeadSurgery;
import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.service.SpecimenService;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * user: ryan.moore
 * date: 11/5/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/db-test-context.xml"})
public class DBIntegrationTest {

    @Autowired
    SurgeryService surgeryService;

    @Autowired
    SpecimenService specimenService;

    @Test
    public void testCreateSurgery() throws SpecimenServiceException {

        Surgery surgery = surgeryService.createSurgery(getHeadSurgery());
        Assert.assertNotNull(surgery);
    }

    @Test
    public void testGetFetchSpecimen() throws SpecimenServiceException {

        Specimen specimen = specimenService.createSpecimen(getHeadSurgery().getSpecimen());
        Assert.assertNotNull(specimen);
        Assert.assertTrue(specimen.getId()!=0);
        Specimen refetchedSpecimen = specimenService.getSpecimenByUUID(specimen.getAnimalUUID());
        Assert.assertNotNull(refetchedSpecimen);
    }



    private HeadSurgery getHeadSurgery() {
        HeadSurgery surgery = new HeadSurgery();
        surgery.setAnalgesiaDose("23G");
        surgery.setAnalgesiaType(AnalgesiaType.KETOPROFEN);
        surgery.setAnesthesiaDosage("1234G");
        surgery.setAnesthesiaType(AnesthesiaType.CHLORAL_HYDRATE);
        surgery.setFreeText("blah blah blah");
        surgery.setProcedureName("Head surgery");
        Specimen specimen = new Specimen();
        specimen.getSurgeryList().add(surgery);
        specimen.setAnimalUUID("R104");
        surgery.setSpecimen(specimen);
        surgery.setSpecimenWeight("14G");
        surgery.setSurgeon("Courtney2");
        surgery.setSurgeryDate(new Date());
        surgery.setTimeEnd("1");
        surgery.setTimeStart("1");
        return surgery;
    }


}
