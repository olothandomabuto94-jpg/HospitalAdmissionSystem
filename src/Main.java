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
                    break;
                case 2:
                    //
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