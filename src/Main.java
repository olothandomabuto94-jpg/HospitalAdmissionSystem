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
            System.out.println("4. Update a patient");
            System.out.println("5. Delete a patient");
            System.out.println("6. Allocate a  bed");
            System.out.println("7. Release a bed");
            System.out.println("8. Display ward layout");
            System.out.println("9. Dispalay available beds");
            System.out.println("10. Display occupied bed");
            System.out.println("11. Display total patients");
            System.out.println("12. Display occupied bed count");
            System.out.println("13. Display occupancy percentage");
            System.out.println("14. Sort by Surname");
            System.out.println("15. Sort by patient ID");
            System.out.println("0. Exit");
            System.out.println("Please choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

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

                case 4:
                    System.out.println("Enter patient ID to update: ");
                    String updateId = scanner.nextLine();
                    Patient existing = ward.searchPatient(updateId);
                    if (existing == null) {
                        System.out.println("No patient found with that ID.");

                    } else {
                        System.out.println("Please enter new name: ");
                        String newFirstName = scanner.nextLine();
                        System.out.println("Please enter new last name: ");
                        String newLastName = scanner.nextLine();
                        System.out.println("Please enter new age: ");
                        int newAge = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Please enter new gender: ");
                        String newGender = scanner.nextLine();
                        System.out.println("Please enter new medical condition:");
                        String newMedicalCondition = scanner.nextLine();

                        ward.updatePatient(updateId, newFirstName, newLastName, newAge, newGender, newMedicalCondition, existing.getPatientCategory());

                    }

                    break;
                case 5:
                    System.out.println("Enter patient ID to delete: ");
                    String deleteId = scanner.nextLine();
                    ward.deletePatient(deleteId);
                    break;

                case 6:
                    System.out.print("Enter Patient ID to allocate a bed: ");
                    String allocateId = scanner.nextLine();
                    Patient foundPatient = ward.searchPatient(allocateId);
                    if (foundPatient == null) {
                        System.out.println("No patient found with that ID.");
                    } else if (!(foundPatient instanceof Inpatient)) {
                        System.out.println("Only Inpatients can be allocated a bed.");
                    } else {
                        Inpatient inpatientToAllocate = (Inpatient) foundPatient;
                        System.out.print("Enter row (0-3): ");
                        int row = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter column (0-4): ");
                        int col = scanner.nextInt();
                        scanner.nextLine();
                        ward.allocateBed(inpatientToAllocate, row, col);
                    }
                    break;

                case 7:
                    System.out.print("Enter row (0-3): ");
                    int releaseRow = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter column (0-4): ");
                    int releaseCol = scanner.nextInt();
                    scanner.nextLine();
                    ward.releaseBed(releaseRow, releaseCol);
                    break;

                case 8:
                    ward.displayWardLayout();
                    break;

                case 9:
                    ward.displayAvailableBeds();
                    break;

                case 10:
                    ward.displayOccupiedBeds();
                    break;

                case 11:
                    ward.displayTotalPatients();
                    break;

                case 12:
                    ward.displayOccupiedBedCount();
                    break;

                case 13:
                    ward.displayOccupancyPercentage();
                    break;

                case 14:
                    ward.sortBySurname();
                    System.out.println("Patients sorted by surname.");
                    break;

                case 15:
                    ward.sortByPatientID();
                    System.out.println("Patients sorted by Patient ID."); //Where's the money, Sonny??
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