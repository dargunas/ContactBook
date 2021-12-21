package contacts;

import java.io.IOException;
import java.util.Scanner;

public class ContactsMain {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ContactServices contactServices = new ContactServices();

        contactServices.showContactMenu();
        contactServices.setEnteredValue(scanner.nextInt());
        contactServices.menuOperations();
    }
}
