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
}