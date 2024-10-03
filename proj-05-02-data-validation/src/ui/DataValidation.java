package ui;

import java.util.Scanner;

public class DataValidation {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Area and Perimeter Calculator");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			//System.out.print("Enter length: ");
			double leng = getDouble("Enter length: ", 0.0, 1000000.0);
			//System.out.print("Enter width: ");
			double width = getDouble("Enter width: ", 0.0, 1000000.0);
			//sc.nextLine();
			
			// logic to calc area and perimeter
			double area = (leng * width);
			double perimeter = (2*(leng + width));
					
			// print area and perimeter
			System.out.println("Area: " + area);
			System.out.println("Perimeter: " + perimeter);
		
			System.out.print("\nContinue? (y/n): ");		
			choice = sc.nextLine();
			
		}		
		System.out.println("Bye");
	}

	private static int getInt(String prompt, int min, int max) {
		boolean success = false;
		int nbr = 0;
		while (!success) {
			System.out.print(prompt);
			if (sc.hasNextInt()) {
				nbr = sc.nextInt();
				if (nbr >= min && nbr <= max) {
                    success = true; // Valid number within range
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
			} else {
				System.out.println("Invalid whole number");
			}
			sc.nextLine();
		}
		return nbr;
	}

	private static double getDouble(String prompt, double min, double max) {
		boolean success = false;
		double nbr = 0;
		while (!success) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				nbr = sc.nextDouble();
				if (nbr >= min && nbr <= max) {
                    success = true; // Valid number within range
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
			} else {
				System.out.println("Invalid double number");
			}
			sc.nextLine();
		}
		return nbr;
	}

	// validate String entry against two acceptable values
	private static String getString(String prompt, String s1, String s2) {
		String str = "";
		boolean success = false;
		while (!success) {
			System.out.print(prompt);
			str = sc.nextLine();
			if (str.length() == 0) {
				System.out.println("Error! This entry is required. Try again");
			} else if (!str.equalsIgnoreCase(s1) && !str.equalsIgnoreCase(s2)) {
				System.out.println("Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			} else {
				success = true;
			}
		}
		return str;
	}
}
