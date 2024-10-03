package ui;

import java.util.Scanner;

public class TableOfPowers {

	public static void main(String[] args) {
		System.out.println("Welcome to the Squares and Cubes table");
		Scanner sc = new Scanner(System.in);
		
		String choice = "y";
		while(choice.equalsIgnoreCase("y")) {
			System.out.print("Enter an integer: ");
			int enter = sc.nextInt();
			sc.nextLine();
		
			// logic for number / squared / cubes
			
			System.out.println("Number\tSquared\tCubed");
			System.out.println("======\t=======\t=====");
			for (int i = 1; i <= enter; i++) {
				int squared = i * i;
				int cube = i * i * i;
				System.out.println(i + "\t" + squared + "\t" + cube);
			}
		
			System.out.print("\nContinue? (y/n): ");		
			choice = sc.nextLine();		
		}
		System.out.println("Bye");
	}

}
