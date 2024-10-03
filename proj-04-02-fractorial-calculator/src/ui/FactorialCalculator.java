package ui;

import java.util.Scanner;

public class FactorialCalculator {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Factorial Calculator");
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			
			int enter = getInt("Enter an integer that's greater than 0 and less than 10: ", 1, 10);
					
			// logic for factorial
			int counter = 1;
			for (int i = 1; i <= enter; i++) {	
				counter *= i;
				}
			System.out.println("The factorial of " + enter + " is " + counter +".");	
			
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
				System.out.println("Invalid number");
			}
			sc.nextLine();
		}
		return nbr;
	}
}


