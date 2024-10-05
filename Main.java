import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Display contact information
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}

class ContactManager {
    private ArrayList<Contact> contacts;
    private Scanner scanner;

    // Constructor
    public ContactManager() {
        contacts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a new contact
    public void addContact() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact phone number: ");
        String phone = scanner.nextLine();
        System.out.println("Enter contact email: ");
        String email = scanner.nextLine();

        Contact newContact = new Contact(name, phone, email);
        contacts.add(newContact);
        System.out.println("Contact added successfully.");
    }

    // Method to view all contacts
    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        }
    }

    // Method to edit an existing contact
    public void editContact() {
        System.out.println("Enter the number of the contact to edit: ");
        int index = scanner.nextInt() - 1; // Index starts from 0
        scanner.nextLine(); // Consume newline left-over

        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.get(index);

            System.out.println("Editing contact: " + contact.getName());
            System.out.println("Enter new name (leave empty to keep unchanged): ");
            String newName = scanner.nextLine();
            if (!newName.isEmpty()) {
                contact.setName(newName);
            }

            System.out.println("Enter new phone number (leave empty to keep unchanged): ");
            String newPhone = scanner.nextLine();
            if (!newPhone.isEmpty()) {
                contact.setPhoneNumber(newPhone);
            }

            System.out.println("Enter new email (leave empty to keep unchanged): ");
            String newEmail = scanner.nextLine();
            if (!newEmail.isEmpty()) {
                contact.setEmail(newEmail);
            }

            System.out.println("Contact updated successfully.");
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    // Method to delete a contact
    public void deleteContact() {
        System.out.println("Enter the number of the contact to delete: ");
        int index = scanner.nextInt() - 1; // Index starts from 0
        scanner.nextLine(); // Consume newline left-over

        if (index >= 0 && index < contacts.size()) {
            Contact contact = contacts.remove(index);
            System.out.println("Deleted contact: " + contact.getName());
        } else {
            System.out.println("Invalid contact number.");
        }
    }

    // Method to display menu options and handle user input
    public void showMenu() {
        int option;
        do {
            System.out.println("\nContact Manager");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    editContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }
}

public class Main {
    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        contactManager.showMenu();
    }
}
