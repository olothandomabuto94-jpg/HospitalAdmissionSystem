import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Ward ward = new Ward();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\n--- Hospital Ward Menu ---");
            System.out.println("1. Register new patient");
            System.out.println("2. Search for a patient");
            System.out.println("3. Display all patients");
            System.out.println("0. Exit");
            System.out.println("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter patient ID: ");
                    String id  = scanner.nextLine();
                    System.out.println("Enter patient name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Enter patient last name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Enter patient gender: ");
                    String gender = scanner.nextLine();
                    System.out.println("Enter patient age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter patient medical condition: ");
                    String medicalCondition = scanner.nextLine();

                    System.out.println("Select category: 1. Inpatient, 2. Outpatient, 3. Emergency");
                    int category = scanner.nextInt();
                    scanner.nextLine();

                    switch (category) {
                        case 1:

                            System.out.println("Enter patient ward number: ");
                            String wardNumber = scanner.nextLine();
                            System.out.println("Enter patient bed number: ");
                            String bedNumber = scanner.nextLine();

                            Inpatient newPatientIn = new Inpatient(id, firstName, lastName, age, gender, medicalCondition, PatientCategory.INPATIENT, wardNumber, bedNumber);
                            ward.registerPatient(newPatientIn);

                            break;
                        case 2:
                            Patient newPatientOut = new Patient(id, firstName, lastName, age, gender, medicalCondition, PatientCategory.OUTPATIENT);
                            ward.registerPatient(newPatientOut);
                            break;
                        case 3:
                            Patient newPatientEmergency = new Patient(id, firstName, lastName, age, gender, medicalCondition, PatientCategory.EMERGENCY);
                            ward.registerPatient(newPatientEmergency);
                            break;
                    }

                    break;
                case 2:
                    System.out.println("Enter patient ID to search: ");
                    String searchId = scanner.nextLine();
                    Patient found = ward.searchPatient(searchId);
                    if (found != null) {
                        found.displayDetails();
                    } else {
                        System.out.println("No patient found with that ID.");
                    }
                    break;

                case 3:
                    ward.displayAllPatients();
                    break;

                case 0:
                    running = false;
                    System.out.println("Good Bye!");
                    break;
                default:
                    System.out.println("Invalid option, please try again.");
            }

        }

    }
}