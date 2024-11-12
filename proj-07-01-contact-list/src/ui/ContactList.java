package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Contact;
import util.Console;

public class ContactList {

	public static void main(String[] args) {
		List<Contact> contacts = new ArrayList<>();
				
		Console.printLine("Welcome to the contact LIst application\n");
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String fname = Console.getRequiredString("\nEnter first name: ");
			String lname = Console.getRequiredString("Enter last name: ");
			String email = Console.getRequiredString("Enter email: ");
			String phone = Console.getRequiredString("Enter phone: \n");
						
			Contact c = new Contact(fname, lname, email, phone);
			contacts.add(c);		
			
			Console.printLine("--------------------------------------");
			Console.printLine("----- Current Contact ----------------");
			Console.printLine("--------------------------------------");
			
			for (Contact contact: contacts) {
				Console.printLine(contact.toString());
			}
			
			Console.printLine("--------------------------------------\n");
			choice = Console.getRequiredString("Continue? (y/n): ");
		}
		
		
	}

}
