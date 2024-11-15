package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import model.Contact;
import util.Console;

public class ContactManagerApp {

	public static void main(String[] args) {
		Console.printLine("Welcome to Contact Manager - Lambdas Version\n");

		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Mike Murach", null, "800-123-4568"));
		contacts.add(new Contact("Anne Boehm", null, null));
		contacts.add(new Contact("Joel Murach", "joel@murach.com", null));
		contacts.add(new Contact("Bubba Murach", "bubba@murach.com", "800-221-8778"));
		
		displayContacts("All Contacts:", contacts);
		
		// show contacts with no phone
		List<Contact> contactsNoPhone = filterContacts(contacts, c -> c.getPhone() == null);
		// Console.printLine("Contacts no phone:");
		displayContacts("Contacts No Phone: ", contactsNoPhone);
		
		// show contacts with no email address
		List<Contact> contactsNoEmail = filterContacts(contacts, c -> c.getEmail() == null);
		displayContacts("Contacts No Email: ", contactsNoEmail);
		
		// show contacts with no phone nor email
		List<Contact> contactsNoPhoneOrEmail = filterContacts(contacts, c -> c.getEmail() == null && c.getPhone() == null);
		displayContacts("Contacts No Phone Or Email",contactsNoPhoneOrEmail);
		
		Console.printLine("\n======= Consumer Interface ========");
		Console.printLine("Print contact names");
		processContacts(contacts, c -> Console.printLine(c.getName()));
		
		Console.printLine("Print contact names, UPPERCASE");
		processContacts(contacts, c -> Console.printLine(c.getName().toUpperCase()));
		
		Console.printLine("\n======= Function Interface ========");
		Console.printLine("Print list of contact names and phone numbers");
		List<String> contactPhoneNumbers = transformContacts(contacts,c -> {
					String phone = c.getPhone() == null ? "n/a" : c.getPhone();
							return c.getName() + ": " + phone;				
				});
		for (String s : contactPhoneNumbers) {
			Console.printLine(s);
		}
		
		Console.printLine("\n======= Contacts Stream method ========");
		contacts.stream().forEach(c -> Console.printLine(c.toString()));
		Console.printLine("Stream to filter and forEach");
		contacts.stream()
				.filter(c -> c.getPhone() == null)
				.forEach(c -> Console.printLine(c.getName())
		);
		
		Console.printLine("\nCollecting a list of contacts w/ no phones.");
		contactsNoPhone = contacts.stream()
				.filter(c -> c.getPhone() == null)
				.collect(Collectors.toList());
		Console.printLine(contactsNoPhone.size() + " contacts w/ no phone.");
		
		Console.printLine("\n======= p. 553 method reference ========");
		List<String> contactNames = contacts.stream()
				.map(Contact::getName)
				.collect(Collectors.toList());
		
		contactNames.stream().forEach(System.out::println);
		contactNames.stream().forEach(Console::printLine);
		
		Console.printLine("\n======= p. 555 map-reduce contacts to a sigle string ========");
		
		String contactsCsv = contacts.stream()
				.map(c -> c.getName())
				.reduce("", (a, b) -> a + b + ", ");
				
		contactsCsv = contactsCsv.substring(0, contactsCsv.length() - 2);
		Console.printLine(contactsCsv);
		
		List<Double> prices = new ArrayList<>();
		prices.addAll(Arrays.asList(15.99, 27.49, 2.50, 1.00, 56.99, 22.99));
		Console.printLine("Max price: ");
		double maxPrice = prices.stream().reduce(0.0, (d1, d2) -> Math.max(d1, d2));
		Console.printLine("Max price is: " + maxPrice);
		
		Console.printLine("\n======= Bonus way to do this ========");
		double maxPrice2 = prices.stream().max(Comparator.naturalOrder()).get();
		Console.printLine("Max price2 is: " + maxPrice2);
		
		
		
		Console.printLine("Bye");
	}
	
	private static List<String> transformContacts(List<Contact> contacts, Function<Contact, String> function){
		List<String> strings = new ArrayList<>();
		for (Contact c: contacts) {
			strings.add(function.apply(c));
		}
		return strings;
	}
	
	// process contacts, accept a contact and do someting
	private static void processContacts (List<Contact> contacts, Consumer<Contact> consumer ) {
		for (Contact c: contacts) {
			consumer.accept(c);
		}
	}

	private static void displayContacts(String header, List<Contact> contactsNoPhone) {
		Console.printLine(header);
		for (Contact c: contactsNoPhone) {
			Console.printLine(c.toString());
		}
		Console.printLine("");
	}
	
	// Predicate without the functional method
	private static List<Contact> filterContacts(List<Contact> contacts, Predicate<Contact> condition) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact c: contacts) {
			if (condition.test(c)) {
				filteredContacts.add(c);
			}
		}
		return filteredContacts;
		
	}
	
	
//	// lambda
//	private static List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
//		List<Contact> filteredContacts = new ArrayList<>();
//		for (Contact c: contacts) {
//			if (condition.test(c)) {
//				filteredContacts.add(c);
//			}
//		}
//		return filteredContacts;
//		
//	}
//
//	private static List<Contact> filterContactsNoEmail(List<Contact> contacts) {
//		List<Contact> filteredContacts = new ArrayList<>();
//		for (Contact c: contacts) {
//			if (c.getEmail() == null) {
//				filteredContacts.add(c);
//			}
//		}
//		return filteredContacts;
//		
//	}
//
//	private static List<Contact> filterContactsNoPhone(List<Contact> contacts) {
//		List<Contact> filteredContacts = new ArrayList<>();
//		for (Contact c: contacts) {
//			if (c.getPhone() == null) {
//				filteredContacts.add(c);
//			}
//		}
//		return filteredContacts;
//	}

}
