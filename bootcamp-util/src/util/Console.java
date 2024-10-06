package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/*
 * This is a utility class to manage
 * the console interaction between an app
 * and a user.
 * 
 * it will include basic getString methods
 * as well as data validation methods.
 * 
 * We plan to create a library for this class
 * and reuse throughout or other console apps.
 */

public class Console {
	public static Scanner sc = new Scanner(System.in);
	
	public static void printLine(String line) {
		System.out.println(line);
	}
	
	// Validations:
	// id		- int
	// title 	- not empty
	// year		- int
	// rating	- G, PG, PG-13, R, NC-17
	// title	- not empty
	
	// Prompt user for a string, empty strings allowed
	public static String getString(String prompt) {
		System.out.print(prompt);
		return sc.nextLine();		
	}
	
	// validate String entry against two acceptable values
	public static String getString(String prompt, String s1, String s2) {
			String str = "";
			boolean success = false;
			while (!success) {
				System.out.print(prompt);
				str = sc.nextLine();
				if (str.length() == 0) {
					System.out.println("Entry is required. Try again");
				} else if (!str.equalsIgnoreCase(s1) && !str.equalsIgnoreCase(s2)) {
					System.out.println("Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
				} else {
					success = true;
				}
			}
			return str;
		}
	
	// prompt user for arequire string (no empty string)
	public static String getRequiredString (String prompt) {
		String str = "";
		boolean success = false;
		while (!success) {
			str = getString(prompt);
			if (str.length() > 0) {
				success = true;
			} else {
				System.out.println("Entry required. Please try again!");
			}
		}
		return str;
	}
	
	public static boolean getRequiredBoolean (String prompt) {
		boolean bool = false;
		boolean success = false;
		while (!success) {
			String input = getString(prompt);
			if (input.equalsIgnoreCase("true")) {
				bool = true;
				success = true;
			} else if (input.equalsIgnoreCase("false")) {
				bool = false;
				success = true;
			} else {
				
				System.out.println("Entry required. Please enter 'true' or 'false'!");
			}
		}
		return bool;
	}
	
	public static LocalDate getRequiredLocalDate(String prompt) {
	    LocalDate date = null;
	    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define the expected date format

	    while (date == null) {
	        String dateString = Console.getRequiredString(prompt);
	        try {
	            date = LocalDate.parse(dateString, dateFormatter); // Parse to LocalDate
	        } catch (DateTimeParseException e) {
	            Console.printLine("Invalid date format. Please use yyyy-MM-dd.");
	        }
	    }
	    return date;
	}
	
	
	// validate against validValues
	public static String getString (String prompt, List<String> validValues) {
		String str = "";
		boolean success = false;
		while (!success) {
			// validae non empty
			str = getRequiredString(prompt);
			for (String s: validValues) {
				if (s.equalsIgnoreCase(str)) {
					success = true;
					break;
				}
			}
			if(!success) {
				printLine("Invalid value. Try again.");
			}
		}
		return str;
	}
	
	public static int getInt(String prompt) {
		int nbr = 0;
		boolean success = false;
		while (!success) {
			System.out.print(prompt);
			if(sc.hasNextInt()) {
				nbr = sc.nextInt();
				success = true;
			} else {
				System.out.println("Error: Please enter whole number!");
			}
			sc.nextLine();
		}
		return nbr;
	}
	
	public static int getInt(String prompt, int min, int max) {
		int nbr = 0;
		boolean success = false;
		while (!success) {
			nbr = getInt(prompt);
			if (nbr < min) {
				System.out.println("Error: Entery mush be at least " + min + ".");
			} else if (nbr > max){
				System.out.println("Error: Entery mush be less than or equal to " + max + ".");
			} else {
				success = true;
			}
		}
		return nbr;
	}
	
	
	public static double getDouble(String prompt) {
		double nbr = 0.0;
		boolean success = false;
		while (!success) {
			System.out.print(prompt);
			if(sc.hasNextDouble()) {
				nbr = sc.nextDouble();
				success = true;
			} else {
				System.out.println("Error: Please enter decimal number!");
			}
			sc.nextLine();
		}
		return nbr;
	}
	
	public static double getDouble(String prompt, double min, double max) {
		double nbr = 0.0;
		boolean success = false;
		while (!success) {
			nbr = getDouble(prompt);
			if (nbr < min) {
				System.out.println("Error: Entery mush be at least " + min + ".");
			} else if (nbr > max){
				System.out.println("Error: Entery mush be less than or equal to " + max + ".");
			} else {
				success = true;
			}
		}
		return nbr;
	}
}




