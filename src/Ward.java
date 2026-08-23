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

        } else {
            System.out.println("Error: No patient found with this ID.");
        }
    }

    public void displayAllPatients() {
        for (Patient p : patients) {
            p.displayDetails();
        }
    }

    public boolean allocateBed(Inpatient patient, int row, int col) {
        if (row < 0 || row > 3 || col < 0 || col > 4) {
            System.out.println("Error: Invalid bed position.");
            return false;
        }
        if (bedGrid[row][col] != null) {
            System.out.println("Error: This bed is occupied.");
            return false;
        }
        bedGrid[row][col] = patient;
        return true;
    }

    public boolean releaseBed(int row, int col) {
        if (row < 0 || row > 3 || col < 0 || col > 4) {
            System.out.println("Error: Invalid bed position.");
            return false;
        }
        if (bedGrid[row][col] == null) {
            System.out.println("This bed is not occupied.");
            return false;
        }
        bedGrid[row][col] = null;
        return true;
    }

    public void displayWardLayout() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int bedNumber = (row * 5) + col + 1;
                String label = "B" +  bedNumber;
                if (bedGrid[row][col] == null) {
                    System.out.println(label + ": is Empty.");
                }
                else {
                    System.out.println(label + ": is currently occupied by "  + bedGrid[row][col].getFirstName() + " " + bedGrid[row][col].getPatientID());
                }
            }
        }
    }

    public void displayAvailableBeds() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int bedNumber = (row * 5) + col + 1;
                String label = "B" + bedNumber;
                if (bedGrid[row][col] == null) {
                    System.out.println(label + ": is Empty and available.");
                }
            }
        }
    }

    public void displayOccupiedBeds() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 5; col++) {
                int bedNumber = (row * 5) + col + 1;
                String label = "B" + bedNumber;
                if (bedGrid[row][col] != null) {
                    System.out.println(label + ": is currently occupied by "  + bedGrid[row][col].getFirstName() + " " + bedGrid[row][col].getPatientID());
                }
            }
        }
    }

}