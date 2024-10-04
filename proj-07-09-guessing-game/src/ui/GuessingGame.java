package ui;

import model.Game;
import util.Console;

public class GuessingGame {

	public static void main(String[] args) {

		Game game = new Game();
		game.displayMessage();
		game.guessHandling();
		Console.printLine("Bye");
	}
}
