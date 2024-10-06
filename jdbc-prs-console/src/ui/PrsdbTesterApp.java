package ui;

import java.util.List;

import db.UserDB;
import model.User;
import util.Console;

public class PrsdbTesterApp {

	public static void main(String[] args) {
		
		Console.printLine("Welcome to the PRSDB Tester App!");

		// Testing User
		Console.printLine("\nList all users:");
		Console.printLine("================");
		listUsers();

		Console.printLine("\nAdd an user:");
		Console.printLine("================");
		addUser();
		
		Console.printLine("\nList all users:");
		Console.printLine("================");
		listUsers();

		Console.printLine("\nGet an user by id:");
		Console.printLine("================");
		getUserById();

		Console.printLine("\nDelete an user:");
		Console.printLine("================");
		deleteUser();

		Console.printLine("\n================");
		Console.printLine("List all users:");
		Console.printLine("================");
		listUsers();
		
		// =================================================================
		// Testing Vendor
		
		
		
		// =================================================================
		// Testing Product
		
		
		
		// =================================================================
		// Testing Request
		
		
		
		// =================================================================
		// Testing Lineitem
		
		
		
		Console.printLine("\nBye");
	}
	
	// User methods =======================================================
		private static void listUsers() {
			List<User> users = UserDB.getAll();
			for (User u : users) {
				Console.printLine(u.toString());
			}
		}
		
		private static void addUser() {
			String username = Console.getRequiredString("Username: ");
			String password = Console.getRequiredString("Password: ");
			String firstName = Console.getRequiredString("FirstName: ");
			String lastName = Console.getRequiredString("LastName: ");
			String phoneNumber = Console.getRequiredString("PhoneNumber: ");
			String email = Console.getRequiredString("Email: ");
			boolean reviewer = Console.getRequiredBoolean("Reviewer: ");
			boolean admin = Console.getRequiredBoolean("Admin: ");
			User u = new User(username, password, firstName, lastName, phoneNumber, email, reviewer, admin);
			if (UserDB.add(u)) {
				Console.printLine("User added.");
			} else {
				Console.printLine("Error adding user.");
				
			}
		}
		
		private static void getUserById() {
			int id = Console.getInt("User Id: ");
			User u = UserDB.get(id);
			if (u != null) {
				Console.printLine(u.toString());
			} else {
				Console.printLine("No user found for id: " + id);
			}
		}
		
		private static void deleteUser() {
			int id = Console.getInt("User Id: ");
			User u = UserDB.get(id);
			if (u != null) {
				if (UserDB.delete(id)) {
					Console.printLine("User deleted.");
				} else {
					Console.printLine("Error deleting user.");
				}
			} else {
				Console.printLine("No user found for id: " + id + ". Cannot delete.");
			}
		}

}
