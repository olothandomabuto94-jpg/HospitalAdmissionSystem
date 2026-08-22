public class Inpatient extends Patient {
    private String wardNumber;
    private String bedNumber;

    public Inpatient(String patientID, String firstName, String lastName, int age, String gender, String medicalCondition, PatientCategory patientCategory, String wardNumber, String bedNumber) {
        super(patientID, firstName, lastName, age, gender, medicalCondition, patientCategory);
        this.wardNumber = wardNumber;
        this.bedNumber = bedNumber;
    }

}

