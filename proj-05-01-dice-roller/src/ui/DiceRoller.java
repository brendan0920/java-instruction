package ui;

import java.util.Scanner;

public class DiceRoller {

	public static void main(String[] args) {
		System.out.println("Dice Roller\n");
		Scanner sc = new Scanner(System.in);
		
		String rollDice = "y";
		System.out.print("Roll the dice? (y/n): ");
		rollDice = sc.next();
		while(rollDice.equalsIgnoreCase("y")) {
			int random1 = (int)(Math.random()*6)+1;
			int random2 = (int)(Math.random()*6)+1;
			int die1 = random1;
			int die2 = random2;
			int total = die1 + die2;
			
			sc.nextLine();
		
			// logic			
						
			System.out.println("Die 1: " + die1);
			System.out.println("Die 2: " + die2);
			System.out.println("Total: " + total);
			if (die1 + die2 == 2) {
				System.out.println("Snake eyes!");
			} else if (die1 + die2 == 12) {
				System.out.println("Boxcars!");
			}
		
			System.out.print("\nRoll again? (y/n): ");		
			rollDice = sc.next();		
		}
		System.out.println("Bye");

	}

}
