package lexicon.workshop;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagementImplementation {

    //Initializing Scanner to get console input
    static Scanner scan = new Scanner(System.in);
    static ContactsDAO contacts = new ContactsDAO();
    static ArrayList<String> contactArray = new ArrayList<>();

    //Method to add a contact
    static void addContact(){
        System.out.print("Enter the name : ");
        contacts.setName(scan.next());
        System.out.print("Enter the Mobile Number : ");
        contacts.setMobileNumber(scan.nextLong());
        //Combining the contact details using | symbol
        String newContact = contacts.getName() + "|" + contacts.getMobileNumber();
        //Check for any duplicates while adding the contact
        for (String contact : contactArray) {
            if (contact.equalsIgnoreCase(newContact)) {
                System.out.println("This contact is already in our registry . Cannot be added again.");
                return;
            }
        }
        contactArray.add(newContact);
        System.out.println("Contact Saved Successfully !!! ");
    }

    //Method to search a contact
    static void searchContact(){
        searchContactMenu();
        boolean contactFound = false;
        boolean choice = true;
        while (choice) {
            int input = scan.nextInt();
            if (input == 1) {
                System.out.print("Enter the name to search : ");
                String nameToSearch = scan.next();
                for(String name : contactArray){
                    //Splitting the contact details into two, name & mobile-number and checking each element if it matches the search criteria
                    String[] contactSplit = name.split("\\|");
                    for(String splitContact : contactSplit) {
                        if (splitContact.equalsIgnoreCase(nameToSearch)) {
                            System.out.println("Searched Contact is : " + name);
                            contactFound = true;
                        }
                    }
                }
                if(!contactFound){
                    System.out.println("Contact Information not found in the registry");
                }
                choice = false;
            } else if (input == 2) {
                System.out.print("Enter the Mobile Number : ");
                long mobileNumber = scan.nextLong();
                for(String name : contactArray){
                    //Splitting the contact details into two, name & mobile-number and checking each element if it matches the search criteria
                    String[] contactSplit = name.split("\\|");
                    for(String splitContact : contactSplit) {
                        if (splitContact.equalsIgnoreCase(String.valueOf(mobileNumber))) {
                            System.out.println("Searched Contact is : " + name);
                            contactFound = true;
                        }
                    }
                }
                //If contact is not found
                if(!contactFound){
                    System.out.println("Contact Information not found in the registry");
                }
                choice = false;
            } else {
                System.out.println("Wrong option entered. Please enter either 1 or 2");
                searchContactMenu();
            }
        }
    }

    //To list all the contacts stored
    static void listContact(){
        System.out.println("List of Contacts : " );
        if(!contactArray.isEmpty()) {
            for (String contact : contactArray) {
                String[] contactSplit = contact.split("\\|");
                System.out.println(contactSplit[0] + " (" + contactSplit[1] + ")");
            }
        }else{
            System.out.println("Sorry, No Contacts available in registry.");
        }
    }

    //menu to decide which type of search is required
    static void searchContactMenu(){
        System.out.println("1.Search By Name");
        System.out.println("2.Search By Mobile Number");
        System.out.print("Choose option : ");
    }
}