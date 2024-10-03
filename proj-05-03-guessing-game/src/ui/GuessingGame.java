package ui;

import java.util.Scanner;

public class GuessingGame {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to the Guess the Number Game");
		System.out.println("++++++++++++++++++++++++++++++++++++");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("I'm thinking of a number from 1 to 100.");
			System.out.println("Try to guess it.\n");
			// random number
			int random = (int)(Math.random() * 100)+1;
			System.out.println("Random#: " + random);

			// logic
			int numberOfGuess = 0;
			boolean success = false;
			while (!success) {
				numberOfGuess++;
				// user prompt
//				System.out.print("\nEnter number: ");
//				int enter = sc.nextInt();
				int enter = getInt("Enter number: ", 1, 100);
				
				
				// if enter > random - too high
				if (enter > random) {
					// if enter - random > 10 - way too high
					if (enter - random > 10) {
						System.out.println("Way too high!");
					} else {
						System.out.println("Too high!");
					}
					continue;
					// if enter < random - too low
				} else if (enter < random) {
					// if random - enter > 10 - way too low
					if (random - enter > 10  ) {
						System.out.println("Way too low");						
					} else {
						System.out.println("Too low");						
					}
					continue;
					// when the user get the random number
				} else {					
					// counter = 1
					if (numberOfGuess == 1) {
						System.out.println("Great work! You are a mathematical wizard.");
					// counter <= 3
					} else if (numberOfGuess <= 3){
						System.out.println("Great work! You are a mathematical wizard.");
					// counter > 3 && counter <= 7					
					} else if (numberOfGuess > 3 && numberOfGuess <= 7){
						System.out.println("Not too bad! You've got some potential.");
					} else {
						System.out.println("What took you so long? Maybe you should take some lessons.");						
					}
					success = true;
				}
			}
			choice = getString("\nContinue? (y/n):", "y", "n");
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

	private static double getDouble(String prompt) {
		boolean success = false;
		double nbr = 0;
		while (!success) {
			System.out.print(prompt);
			if (sc.hasNextDouble()) {
				nbr = sc.nextDouble();
				success = true;
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
				System.out.println("Entry is required. Try again");
			} else if (!str.equalsIgnoreCase(s1) && !str.equalsIgnoreCase(s2)) {
				System.out.println("Entry must be '" + s1 + "' or '" + s2 + "'. Try again.");
			} else {
				success = true;
			}
		}
		return str;
	}
}
