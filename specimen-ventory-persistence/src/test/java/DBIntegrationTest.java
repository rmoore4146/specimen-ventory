import com.specimen.inventory.model.AnalgesiaType;
import com.specimen.inventory.model.AnesthesiaType;
import com.specimen.inventory.model.Specimen;
import com.specimen.inventory.model.Surgery;
import com.specimen.inventory.model.SurgeryType;
import com.specimen.inventory.model.TableColumnDefinition;
import com.specimen.inventory.model.TableColumnType;
import com.specimen.inventory.service.SpecimenService;
import com.specimen.inventory.service.SurgeryService;
import com.specimen.inventory.service.TableColumnDefinitionService;
import com.specimen.inventory.service.exception.SpecimenServiceException;
import com.specimen.inventory.service.exception.SurgeryServiceException;
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

    @Autowired
    TableColumnDefinitionService tableColumnDefinitionService;

    @Test
    public void testCreateSurgery() throws SurgeryServiceException {

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

    @Test
    public void testFetchSpecimen() throws SpecimenServiceException {

        Specimen refetchedSpecimen = specimenService.getSpecimenByUUID(getHeadSurgery().getSpecimen().getAnimalUUID());
        Assert.assertNotNull(refetchedSpecimen);
    }

    @Test
    public void testFetchSpecimenDoesntExist() throws SpecimenServiceException {

        Specimen specimen = specimenService.getSpecimenByUUID("a uuid that doesnt exist");
        Assert.assertNull(specimen);
    }

    @Test
    public void testPersistFetchSurgeryDoesntExist() throws SpecimenServiceException {

        Specimen specimen = specimenService.getSpecimenByUUID("a uuid that doesnt exist");
        Assert.assertNull(specimen);
    }

    @Test
    public void testPersistTableColumnDefinition() throws Exception {
        TableColumnDefinition def = tableColumnDefinitionService.saveTableColumnDefinition(getTableColumnDefinition());
        Assert.assertNotNull(def);
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

    private TableColumnDefinition getTableColumnDefinition() {
        TableColumnDefinition def = new TableColumnDefinition();
        def.setColumnName("Blah blah");
        def.setEditable(true);
        def.setEnabled(true);
        def.setType(TableColumnType.TEXT);
        def.setViewedByDefault(true);
        return def;
    }
}