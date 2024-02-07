package question2;

import java.util.ArrayList;
import java.util.Scanner;

public class DirectoryRunner {

	public static Scanner scanner = new Scanner(System.in);
	public static ArrayList<DirectoryEntry> entries;

    public static void menu() {
        int choice;

        do {
            System.out.println("\nDirectory Menu:");
            System.out.println("1. Create a database entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Search by keyword");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    createEntry();
                    break;
                case 2:
                    editEntry();
                    break;
                case 3:
                    searchByKeyword();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 4);
    }

    private static void createEntry() {

        System.out.println("\nEnter details for the new entry:");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Address: ");
        String address = scanner.nextLine();

        System.out.print("Telephone Number (if available with STD code): ");
        String telephoneNumber = scanner.nextLine();

        System.out.print("Mobile Number (if available): ");
        String mobileNumber = scanner.nextLine();

        System.out.print("Head of Family: ");
        String headOfFamily = scanner.nextLine();

        DirectoryEntry entry = new DirectoryEntry(name, address, headOfFamily);
        if(isValidTelephoneNumber(telephoneNumber, headOfFamily)) {
        	entry.setTelephoneNumber(telephoneNumber.strip());
        }
        if(!mobileNumber.strip().isBlank()) {
        	entry.setMobileNumber(mobileNumber.strip());
        }
        entries.add(entry);
        System.out.println("Entry created successfully.");
    }
    
    private static boolean isValidTelephoneNumber(String telephoneNumber, String headOfFamily) {
    	if(!telephoneNumber.strip().isBlank()) {
        	for(DirectoryEntry entry: entries) {
        		if(entry.getTelephoneNumber().equals(telephoneNumber.strip())) {
        			if(!entry.getHeadOfFamily().equals(headOfFamily)) {
        				System.out.println("Telephone numbers cannot be same if you don't have the same head of family.");
        				return false;
        			}
        		}
        	}
        	return true;
        }
    	return false;
    }

    private static void editEntry() {
    	System.out.println("");
    	System.out.println("---------------------------------------------------");
    	System.out.println("");
    	
    	System.out.println("Available Entries.");
    	for(DirectoryEntry entry: entries) {
    		System.out.println(entry);
    	}
    	
    	System.out.println("");
    	System.out.println("---------------------------------------------------");
    	System.out.println("");
    	
        System.out.print("\nEnter Unique ID of the entry to edit: ");
        Integer uniqueID = scanner.nextInt();
        scanner.nextLine();

        for (DirectoryEntry entry : entries) {
            if (entry.getUniqueID().equals(uniqueID)) {
                System.out.println("Editing entry with Unique ID: " + uniqueID);


                System.out.print("Edit Name (" + entry.getName() + "): ");
                String name = scanner.nextLine();

                System.out.print("Edit Address (" + entry.getAddress() + "): ");
                String address = scanner.nextLine();

                System.out.print("Edit Telephone Number (if available with STD code) (" + entry.getTelephoneNumber() + "): ");
                String telephoneNumber = scanner.nextLine();

                System.out.print("Edit Mobile Number (if available)(" + entry.getMobileNumber() + "): ");
                String mobileNumber = scanner.nextLine();

                System.out.print("Edit Head of Family (" + entry.getHeadOfFamily() + "): ");
                String headOfFamily = scanner.nextLine();
                
                if(!name.strip().isEmpty()) {
                	entry.setName(name);
                }
                
                if(!address.strip().isEmpty()) {
                	entry.setAddress(address);
                }
                
                if(isValidTelephoneNumber(telephoneNumber, headOfFamily)) {
                	entry.setTelephoneNumber(telephoneNumber.strip());
                }
                if(!mobileNumber.strip().isEmpty()) {
                	entry.setMobileNumber(mobileNumber.strip());
                }
                
                if(!headOfFamily.strip().isEmpty()) {
                	entry.setHeadOfFamily(headOfFamily);
                }

                System.out.println("Entry edited successfully.");
                System.out.println("");
            	System.out.println("---------------------------------------------------");
            	System.out.println("");
                return;
            }
        }

        System.out.println("Entry with Unique ID " + uniqueID + " not found.");
        System.out.println("");
    	System.out.println("---------------------------------------------------");
    	System.out.println("");
    }

    private static void searchByKeyword() {
    	System.out.println("");
    	System.out.println("---------------------------------------------------");
    	System.out.println("");
        System.out.print("\nEnter keyword to search: ");
        String keyword = scanner.nextLine().toLowerCase();

        System.out.println("\nSearch Results:");

        for (DirectoryEntry entry : entries) {
            if (entry.getName().toLowerCase().contains(keyword) ||
                entry.getAddress().toLowerCase().contains(keyword) ||
                entry.getTelephoneNumber().toLowerCase().contains(keyword) ||
                entry.getMobileNumber().toLowerCase().contains(keyword) ||
                entry.getHeadOfFamily().toLowerCase().contains(keyword)) {
                displayEntry(entry);
            }
        }
        
        System.out.println("");
    	System.out.println("---------------------------------------------------");
    	System.out.println("");
    }

    private static void displayEntry(DirectoryEntry entry) {
        System.out.println("\nName: " + entry.getName());
        System.out.println("Address: " + entry.getAddress());
        System.out.println("Telephone Number: " + entry.getTelephoneNumber());
        System.out.println("Mobile Number: " + entry.getMobileNumber());
        System.out.println("Head of Family: " + entry.getHeadOfFamily());
        System.out.println("Unique ID: " + entry.getUniqueID());
    }
	
    public static void main(String[] args) {
    	entries = new ArrayList<>();
    	menu();
    }
}
