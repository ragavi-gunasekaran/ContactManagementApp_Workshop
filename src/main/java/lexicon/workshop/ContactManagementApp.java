package lexicon.workshop;

import java.util.ArrayList;
import java.util.Scanner;
import static lexicon.workshop.ContactManagementImplementation.addContact;

public class ContactManagementApp {

    //Initializing Scanner to get console input
    static Scanner scan = new Scanner(System.in);

    static void main() {

        displayMenu();
        //getting the menu choice from console
        int input = scan.nextInt();
        switch (input){
            case 1:
                System.out.println("Add a New Contact");
                addContact();
                break;
            case 2:
                System.out.println("Search a Contact");

                break;
            case 3:
                System.out.println("List all Contact");
                break;
            case 0:
                System.out.println("Exiting the Contact Management Application");
                break;
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
