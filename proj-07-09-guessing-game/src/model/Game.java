package model;

import util.Console;

public class Game {

	public int random() {
		int random = (int) (Math.random() * 100) + 1;
		System.out.println("Random#: " + random);
		return random;
	}

	public void displayMessage() {
		Console.printLine("Welcome to the Guess the Number Game");
		Console.printLine("++++++++++++++++++++++++++++++++++++");
	}

	public void guessHandling() {
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.println("I'm thinking of a number from 1 to 100.");
			System.out.println("Try to guess it.\n");
			// random number
			int random = random();

			// logic
			int numberOfGuess = 0;
			boolean success = false;
			while (!success) {
				numberOfGuess++;
				// user prompt

				int enter = Console.getInt("Enter number: ", 1, 100);

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
					if (random - enter > 10) {
						System.out.println("Way too low");
					} else {
						System.out.println("Too low");
					}
					continue;
					// when the user get the random number
				} else {
					// counter = 1
					if (numberOfGuess == 1) {
						System.out.println("You got it in " + numberOfGuess + " try.\nGreat work! You are a mathematical wizard.");
						// counter <= 3
					} else if (numberOfGuess <= 3) {
						System.out.println("You got it in " + numberOfGuess + " tries.\nGreat work! You are a mathematical wizard.");
						// counter > 3 && counter <= 7
					} else if (numberOfGuess > 3 && numberOfGuess <= 7) {
						System.out.println("You got it in " + numberOfGuess + " tries.\nNot too bad! You've got some potential.");
					} else {
						System.out.println("You got it in " + numberOfGuess + " tries.\nWhat took you so long? Maybe you should take some lessons.");
					}
					success = true;
				}
			}
			choice = Console.getString("\nContinue? (y/n):", "y", "n");
		}

	}
}
