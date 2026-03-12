package lexicon.workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagementImplementation {

    //Initializing Scanner to get console input
    static Scanner scan = new Scanner(System.in);
    static ContactsDAO contacts = new ContactsDAO();
    static ArrayList<String> contactArray = new ArrayList<String>();

    static void addContact(){
        System.out.print("Enter the name : ");
        contacts.setName(scan.next());
        System.out.print("Enter the Mobile Number : ");
        contacts.setMobileNumber(scan.nextLong());
        String newContact = contacts.getName() + "|" + contacts.getName();
        // check duplicate
        for (String contact : contactArray) {
            if (contact.equalsIgnoreCase(newContact)) {
                System.out.println("This contact is already in our registry . Cannot be added again.");
                return;
            }
        }
        contactArray.add(newContact);
        System.out.println("Saving the Contact: " + contactArray);
    }

    static void searchContact(){
        searchContactMenu();
        boolean choice = true;
        while (choice) {
            int input = scan.nextInt();
            if (input == 1) {
                System.out.print("Enter the name to search : ");
                String nameToSearch = scan.next();
                for(String name : contactArray){
                    if(name.equalsIgnoreCase(nameToSearch)){
                        System.out.println("Searched Contact is : " + name);
                    }
                }
                choice = false;
            } else if (input == 2) {
                System.out.print("Enter the Mobile Number : ");
                long mobileNumber = scan.nextLong();
                for(String number : contactArray){
                    if(number.equalsIgnoreCase(String.valueOf(mobileNumber))){
                        System.out.println("Searched Contact is : " + number);
                    }
                }
                choice = false;
            } else {
                System.out.println("Wrong option entered. Please enter either 1 or 2");
                searchContactMenu();
                choice = true;
            }
        }
    }

    static void listContact(){
        System.out.println("List of Contacts : " + contactArray);
    }

    static void searchContactMenu(){
        System.out.println("1.Search By Name");
        System.out.println("2.Search By Mobile Number");
        System.out.print("Choose option : ");
    }
}
