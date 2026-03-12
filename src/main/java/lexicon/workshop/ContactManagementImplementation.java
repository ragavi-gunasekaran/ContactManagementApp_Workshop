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
        contactArray.add(contacts.getName());
        contactArray.add(String.valueOf(contacts.getMobileNumber()));
        System.out.println("Display " + contactArray);
    }
}
