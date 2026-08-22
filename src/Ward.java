import java.util.ArrayList;

public class Ward {
    private ArrayList<Patient> patients = new ArrayList<>();

    private Patient[][] bedGrid = new Patient[4][5];

    private boolean isDuplicated(String id) {
        for (Patient p : patients) {
            if (p.getPatientID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void registerPatient(Patient patient) {
        if (isDuplicated(patient.getPatientID())) {
            System.out.println("Error: A patient with this ID already exists.");
        } else {
            patients.add(patient);
        }
    }

    public Patient searchPatient(String id) {
        for (Patient p : patients) {
            if (p.getPatientID().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void deletePatient(String id) {
        Patient found = searchPatient(id);
        if (found != null) {
            patients.remove(found);
        } else {
            System.out.println("Error: No patient found with this ID.");
        }
    }

    public void updatePatient(String id, String firstName, String lastName, int age, String gender, String medicalCondition, PatientCategory category) {
        Patient found = searchPatient(id);
        if (found != null) {

            found.setFirstName(firstName);
            found.setLastName(lastName);
            found.setAge(age);
            found.setGender(gender);
            found.setMedicalCondition(medicalCondition);
            found.setPatientCategory(category);

        }
        else {
            System.out.println("Error: No patient found with this ID.");
        }
    }

    public void displayAllPatients() {
        for (Patient p : patients) {
            p.displayDetails();
        }
    }

}