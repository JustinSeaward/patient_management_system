package com.project;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int userChoice;

        do {
            System.out.println("\n==================================");
            System.out.println("=== Patient Management Program ===");
            System.out.println("==================================\n");
            System.out.println("1. Add patient");
            System.out.println("2. Remove patient");
            System.out.println("3. Search patient by name");
            System.out.println("4. Display patients");
            System.out.println("9. Exit\n");
            System.out.print("Enter choice: ");

            while (!input.hasNextInt()) {
                System.out.println("\nInvalid input! Please enter a number.");
                input.next();
            }

            userChoice = input.nextInt();
            input.nextLine();

            // switch/case to call methods choice to run by the user
            switch (userChoice) {
                case 1:
                    System.out.println("Add patient");
                    break;
                case 2:
                    System.out.println("Remove patient");
                    break;
                case 3:
                    System.out.println("Search patient by name");
                    break;
                case 4:
                    System.out.println("Display patient");
                    break;
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

        input.close();
    }

}
