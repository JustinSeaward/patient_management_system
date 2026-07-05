package com.project;

import com.project.patient.Patient;
import com.project.patient.PatientWaitingRoom;
import com.project.patientrecord.PatientHistorySystem;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private static PatientWaitingRoom waitingRoom = new PatientWaitingRoom();
    private static PatientHistorySystem historySystem = new PatientHistorySystem();
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++){
            LocalDate dummyDate = LocalDate.now().minusDays(i);
            String dummyDiagnosis = "Checkup " + i;
            String dummyTreatment = "Standard care " + i;
            historySystem.insertPatientRecord(dummyDate,dummyDiagnosis, dummyTreatment);
        }

        int userChoice;

        do {
            System.out.println("\n==================================");
            System.out.println("=== Patient Management Program ===");
            System.out.println("==================================\n");
            System.out.println("1. Add patient");
            System.out.println("2. Serve next patient");
            System.out.println("3. View patient history");
            System.out.println("4. List patients in waiting room");
            System.out.println("5. ADD EMERGENCY PATIENT");
            System.out.println("6. Display newest patient record");
            System.out.println("7. Display oldest patient record");
            System.out.println();
            System.out.println("9. Exit\n");
            System.out.print("Enter choice: ");

            while (!userInput.hasNextInt()) {
                System.out.println("\nInvalid input! Please enter a number.");
                userInput.next();
            }

            userChoice = userInput.nextInt();
            userInput.nextLine();

            // switch/case to call methods choice to run by the user
            switch (userChoice) {
                case 1:
                    handleAddPatient();
                    break;
                case 2:
                    handleServeNextPatient();
                    break;
                case 3:
                    handleViewPatientHistory();
                    break;
                case 4:
                    handleDisplayPatientWaitingRoomList();
                    break;
                case 5:
                    handleAddEmergencyPatient();
                    break;
                case 6:
                    handleDisplayNewestPatientRecord();
                    break;
                case 7:
                    handleDisplayOldestPatientRecord();
                case 9:
                    System.out.println("\nExiting the program...");
                    System.out.println("Good bye");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please select a valid option.");
            }
        }
        // Exit program when user enters 9
        while (userChoice != 9);
        userInput.close();
    }

    public static Patient gatherPatientDetails(){
            System.out.println("***********************");
            System.out.println("*** Add new patient ***");
            System.out.println("***********************\n");
            System.out.println("Enter patient id: ");
            int id = userInput.nextInt();
            userInput.nextLine();
            System.out.println("Enter patients first name: ");
            String firstName = userInput.nextLine();
            System.out.println("Enter patients last name: ");
            String lastName = userInput.nextLine();
            System.out.println("Enter patients phone number: ");
            String phoneNumber = userInput.nextLine();
            System.out.println("Enter patients date of birth Ex 1969-10-10: ");
            LocalDate dateOfBirth = LocalDate.parse(userInput.next());
            userInput.nextLine();
            System.out.println("Enter reason for visit: ");
            String reasonForVisit = userInput.nextLine();

            return new Patient(id,firstName,lastName,phoneNumber,dateOfBirth,reasonForVisit);
    }

    public static void handleAddPatient() {
        String exitChoice = "";
        do{
            Patient newPatient = gatherPatientDetails();
            waitingRoom.addPatient(newPatient,1);

            System.out.println("Would you add another patient? (Y/N): ");
            exitChoice = userInput.nextLine();
        } while(!exitChoice.equalsIgnoreCase("N"));
    }

    public static void handleAddEmergencyPatient() {
        String exitChoice = "";
        do{
            System.out.println("************************");
            System.out.println("*** EMERGENCY INTAKE ***");
            System.out.println("************************\n");
            Patient newPatient = gatherPatientDetails();
            waitingRoom.addPatient(newPatient,0);

            System.out.println("Would you add another emergency patient? (Y/N): ");
            exitChoice = userInput.nextLine();
        } while(!exitChoice.equalsIgnoreCase("N"));
    }

    public static void handleServeNextPatient() {
        String exitChoice = "";
        do{
            System.out.println("****************************");
            System.out.println("*** Serving Next patient ***");
            System.out.println("****************************");
            Patient nextPatient = waitingRoom.serveNextPatientInLine();
            if(nextPatient == null){
                System.out.println("Waiting room is empty.");
                return;
            }
            System.out.println(nextPatient);
            System.out.println("Would you like to add a record for this patient? (Y/N): ");
            String newRecord = userInput.nextLine();
            if(newRecord.equalsIgnoreCase("y")){
                gatherPatientRecordDetails();
            }
            System.out.println("\n Exit to main menu? (Y/N): ");
            exitChoice = userInput.nextLine();
        }
        while (!exitChoice.equalsIgnoreCase("Y"));
    }

    public static void handleViewPatientHistory() {
        String navChoice;
        System.out.println("***********************");
        System.out.println("*** Patient History ***");
        System.out.println("***********************");
        historySystem.displayNewestPatientRecord();
        do {
            System.out.println();
            System.out.println("[P]revious Record | [N]ext Record | [Q]uit to Main Menu");

            while (!userInput.hasNext()) {
                System.out.println("\nInvalid input, enter P, N, or Q.");
                userInput.next();
            }

            navChoice = userInput.nextLine();
            switch (navChoice.toUpperCase()) {
                case "P":
                    historySystem.moveToPreviousPatientRecord();
                    break;
                case "N":
                    historySystem.moveToNextPatientRecord();
                    break;
                case "Q":
                    System.out.println("\nExiting to main menu...");
                    break;
                default:
                    System.out.println("\nInvalid choice! Please select a valid option, enter P, N, or Q.");
            }
        }while (!navChoice.equalsIgnoreCase("q"));

    }

    public static void handleDisplayPatientWaitingRoomList(){
        String exitChoice = "";
        do{
            waitingRoom.displayPatientWaitingRoomList();
            System.out.println("\n");
            System.out.println("Would you like to exit to main menu? (Y/N): ");
            exitChoice = userInput.nextLine();
        } while(exitChoice.equalsIgnoreCase("n"));
    }

    public static void gatherPatientRecordDetails(){
        String exitChoice = "";
        do{
            System.out.println("**************************");
            System.out.println("*** Add Patient Record ***");
            System.out.println("**************************\n");
            System.out.println("Visit date: " + LocalDate.now());
            LocalDate visitDate = LocalDate.now();
            System.out.println("Enter diagnosis: ");
            String diagnosis = userInput.nextLine();
            System.out.println("Enter patient treatment: ");
            String treatment = userInput.nextLine();

            historySystem.insertPatientRecord(visitDate, diagnosis, treatment);
            System.out.println("\nPatient's new record saved");

            System.out.println("\n");
            System.out.println("Would you like to exit record menu? (Y/N): ");
            exitChoice = userInput.nextLine();
        } while(exitChoice.equalsIgnoreCase("n"));
    }

    public static void handleDisplayOldestPatientRecord() {
        String exitChoice = "";
        do{
            System.out.println("*****************************");
            System.out.println("*** Oldest Patient Record ***");
            System.out.println("*****************************\n");
            historySystem.displayOldestPatientRecord();

            System.out.println("\nWould you like to exit record menu? (Y/N): ");
            exitChoice = userInput.nextLine();
        } while(exitChoice.equalsIgnoreCase("n"));
    }

    public static void handleDisplayNewestPatientRecord() {
        String exitChoice = "";
        do{
            System.out.println("*****************************");
            System.out.println("*** Newest Patient Record ***");
            System.out.println("*****************************\n");
            historySystem.displayNewestPatientRecord();

            System.out.println("\nWould you like to exit record menu? (Y/N): ");
            exitChoice = userInput.nextLine();
        } while(exitChoice.equalsIgnoreCase("n"));
    }
}
