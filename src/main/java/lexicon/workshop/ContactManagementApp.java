package lexicon.workshop;

import java.util.Scanner;
import static lexicon.workshop.ContactManagementImplementation.*;

public class ContactManagementApp {

    //Initializing Scanner to get console input
    static Scanner scan = new Scanner(System.in);

    static void main() {

        displayMenu();
        //getting the menu choice from console
        int input = scan.nextInt();
        boolean value = true;
        while (value) {
            switch (input) {
                case 1:
                    System.out.println("Add a New Contact");
                    addContact();
                    break;
                case 2:
                    System.out.println("Search a Contact");
                    searchContact();
                    break;
                case 3:
                    System.out.println("List all Contact");
                    listContact();
                    break;
                case 0:
                    System.out.println("Exiting the Contact Management Application");
                    break;
            }

            //To check if the user has to still proceed with Contact Management application or not
            IO.println("Do you want to still continue with Contact Management App?(Yes/No)");
            boolean isRight = true;
            while (isRight) {
                String option = scan.next();
                if (option.equalsIgnoreCase("Yes")) {
                    displayMenu();
                    input = scan.nextInt();
                    isRight = false;
                } else if (option.equalsIgnoreCase("No")) {
                    value = false;
                    IO.println("Exiting the Contact Management Application, Thanks !!!!!!");
                    isRight = false;
                } else {
                    IO.println("Wrong option entered. Please enter Yes or No");
                }
            }
        }
    }

    //Application Menu
    static void displayMenu(){
        System.out.println("====================== Welcome to Contact Management ======================");
        System.out.println("1.Add Contact");
        System.out.println("2.Search by Name");
        System.out.println("3.Display All Contacts");
        System.out.println("0.Exit");
        System.out.print("Choose an option: ");
    }
}