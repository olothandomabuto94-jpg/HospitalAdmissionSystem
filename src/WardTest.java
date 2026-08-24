import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WardTest {

    @Test
    public void testRegisterPatient() {
        Ward ward = new Ward();
        Patient patient = new Patient("P001", "John", "Doe", 30, "Male", "Flu", PatientCategory.OUTPATIENT);

        ward.registerPatient(patient);

        assertEquals(patient, ward.searchPatient("P001"));
    }

    @Test
    public void testSearchPatient() {
        Ward ward = new Ward();
        Patient patient = new Patient("P002", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.OUTPATIENT);
        ward.registerPatient(patient);


        assertEquals(patient, ward.searchPatient("P002"));

        assertNull(ward.searchPatient("P003"));
    }

    @Test
    public void testUpdatePatient() {
        Ward ward = new Ward();
        Patient patient = new Patient("P002", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.OUTPATIENT);
        ward.registerPatient(patient);
        ward.updatePatient("P002", "Jane", "Smith", 37, "Female", "Lung Cancer", PatientCategory.OUTPATIENT);
        assertEquals(37, ward.searchPatient("P002").getAge());
    }

    @Test
    public void testDeletePatient() {
        Ward ward = new Ward();
        Patient patient = new Patient("P002", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.OUTPATIENT);
        ward.registerPatient(patient);
        ward.deletePatient("P002");
        assertNull(ward.searchPatient("P002"));
    }

    @Test
    public void testAllocateBed() {
        Ward ward = new Ward();
        Inpatient patient = new Inpatient("P002", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.INPATIENT, "W01", "B07");
        ward.registerPatient(patient);
        assertTrue(ward.allocateBed(patient, 2, 3));
    }

    @Test
    public void testReleaseBed() {
        Ward ward = new Ward();
        Inpatient patient = new Inpatient("P002", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.OUTPATIENT,  "W01", "B07");
        ward.registerPatient(patient);
        ward.allocateBed(patient, 2, 3);
        assertTrue(ward.releaseBed(2, 3));

        assertTrue(ward.allocateBed(patient, 2, 3));
    }

    @Test
    public void testPreventDuplicateID() {
        Ward ward = new Ward();
        Patient patient1 = new Patient("P002", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.OUTPATIENT);
        Patient patient2 = new Patient("P002", "Bob", "Jones", 40, "Male", "Flu", PatientCategory.OUTPATIENT);

        ward.registerPatient(patient1);
        ward.registerPatient(patient2);

        assertEquals("Jane", ward.searchPatient("P002").getFirstName());
    }

    @Test
    public void testPreventOccupiedAllocation() {
        Ward ward = new Ward();
        Inpatient patient1 = new Inpatient("P001", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.INPATIENT, "W01", "B07");
        Inpatient patient2 = new Inpatient("P002", "Bob", "Jones", 40, "Male", "Flu", PatientCategory.INPATIENT, "W01", "B08");
        ward.registerPatient(patient1);
        ward.registerPatient(patient2);

        ward.allocateBed(patient1, 0, 0);
        assertFalse(ward.allocateBed(patient2, 0, 0));
    }

    @Test
    public void testPreventAllocationWhenFull() {
        Ward ward = new Ward();
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                Inpatient p = new Inpatient("P" + row + col, "First", "Last", 30, "Male", "Cold", PatientCategory.INPATIENT, "W01", "B01");
                ward.registerPatient(p);
                ward.allocateBed(p, row, col);
            }
        }

        Inpatient extra = new Inpatient("P999", "Extra", "Patient", 30, "Male", "Cold", PatientCategory.INPATIENT, "W01", "B99");
        ward.registerPatient(extra);
        assertFalse(ward.allocateBed(extra, 0, 0));
    }

    @Test
    public void testSortBySurname() {
        Ward ward = new Ward();
        Patient p1 = new Patient("P001", "Alice", "Zephyr", 20, "Female", "Cold", PatientCategory.OUTPATIENT);
        Patient p2 = new Patient("P002", "Bob", "Adams", 30, "Male", "Flu", PatientCategory.OUTPATIENT);
        ward.registerPatient(p1);
        ward.registerPatient(p2);

        ward.sortBySurname();

        assertEquals("Adams", ward.getPatients().get(0).getLastName());
    }

}