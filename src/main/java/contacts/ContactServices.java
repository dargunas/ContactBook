package contacts;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactServices {
    Scanner scanner = new Scanner(System.in);

    Contacts contacts = new Contacts();

    public int enteredValue;


    public ContactServices() throws IOException {
    }


    public void showContactMenu() {
        System.out.println("Contact menu -->");
        System.out.println("Chose one of following --->");
        System.out.println("            [1]     to show all contacts ");
        System.out.println("            [2]     to add contact");
        System.out.println("            [3]     to remove contact");
        System.out.println("            [4]     to find contact");
        System.out.println("            [5]     to edit contact");
        System.out.println("            [6]     to exit menu");

    }

    public void menuOperations() throws IOException {
        switch (enteredValue) {
            case 1:
                showAllContacts();
                break;
            case 2:
                addContact();
                break;
            case 3:
                removeContact();
                break;
            case 4:
                findContact();
                break;
            case 5:
                editContact();
                break;
            case 6:
                break;
        }
    }

    public void addContact() throws IOException {

        /**
         * Pasiziureti, kaip ideti duomenis i kazkoki array, kad butu galima moderuoti json faila.
         * istraukti viska is failo, sudeti i array, prideti nauja kontakta ir viska sukisti atgal i json faila.
         *
         *
         * Su skaneriu paziuret kas gerro.... ir kad programa suktusi, kol neivestas 6.....
         */

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("src/main/resources/contactList.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        Contacts contacts = new Contacts();

        System.out.println("Enter name:");
        contacts.setName(scanner.next());
        System.out.println("Enter lastname:");
        contacts.setLastName(scanner.next());
        System.out.println("Enter email:");
        contacts.setEmail(scanner.next());
        System.out.println("Enter phone number:");
        contacts.setPhoneNumber(scanner.next());

        Map<String, Object> contact = new HashMap<>();
        contact.put("Name", contacts.getName());
        contact.put("Last name", contacts.getLastName());
        contact.put("email", contacts.getEmail());
        contact.put("Phone number", contacts.getPhoneNumber());

        writer.write(objectMapper.writeValueAsString(contact));
        writer.close();

        showContactMenu();
        enteredValue = scanner.nextInt();
        menuOperations();
    }


    public void editContact() throws IOException {

        showContactMenu();
        enteredValue = scanner.nextInt();
        menuOperations();


    }

    public void removeContact() throws IOException {

        showContactMenu();
        enteredValue = scanner.nextInt();
        menuOperations();
    }

    public void showAllContacts() throws IOException {

        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/contactList.json"));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode parser = objectMapper.readTree(reader);
        System.out.println(parser.path("Name").asText());
        System.out.println(parser.path("Last name").asText());
        System.out.println(parser.path("email").asText());
        System.out.println(parser.path("Phone number").asText());
        reader.close();

        showContactMenu();
        enteredValue = scanner.nextInt();
        menuOperations();

    }

    public void findContact() throws IOException {

        showContactMenu();
        enteredValue = scanner.nextInt();
        menuOperations();

    }

    public int getEnteredValue() {
        return enteredValue;
    }

    public void setEnteredValue(int enteredValue) {
        this.enteredValue = enteredValue;
    }
}
