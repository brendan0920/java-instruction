package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import db.MovieDB;
import model.Movie;
import util.Console;

public class MovieRatingsApp {

	static List<Movie> movies;

	public static void main(String[] args) {
		movies = new ArrayList<>();
		Console.printLine("Welcome to the Movie Ratings application!");

		// display menu
		displayMenu();

		// while
		int command = 0;
		while (command != 6) {
			// prompt from user
			command = Console.getInt("\nChoose a menu option: ", 1, 6);

			// switch
			switch (command) {
			// Enter a movie
			case 1:
				addMovie();
				Console.printLine("\n~~~~ menu repeats here ~~~~");
				break;

			// View top rated movie
			case 2:
				getMoviesByTopRated();
//				List<Movie> topRatedMovies = filterMovies(movies, m -> m.getRating() > 3.9);
//				displayMovies(topRatedMovies);
				break;

			// View most recent movies
			case 3:
				getMostRecentMovie();
				break;

			// View all movies
			case 4:
				// listMovies();
				List<Movie> displayAllMovies = filterMovies(movies, m -> m.getYear() > 1900);
				displayMovies(displayAllMovies);
				break;

			// View ratings
			case 5:
				getRatings();
				break;

			// Quit application
			case 6:
				break;
			}

		}
		Console.printLine("\nBye");
	}

	private static void displayMovies(List<Movie> displayMovie) {
		Console.printLine("");
		for (Movie m : displayMovie) {
			Console.printLine(m.toString());
		}
		
	}

	public static List<Movie> filterMovies(List<Movie> movies, Predicate<Movie> condition) {
		List<Movie> filteredMovies = MovieDB.getAll();;
		for (Movie m : movies) {
			if (condition.test(m)) {
				filteredMovies.add(m);
			}
		}
		return filteredMovies;
	}

	private static void addMovie() {
		int userInput = Console.getInt("\nHow many movies do you want to enter? ");
		for (int i = 1; i <= userInput; i++) {

			Console.printLine("Movie #" + i);
			Console.printLine("----------");

			String title = Console.getRequiredString("Enter title: ");
			int year = Console.getInt("Enter year: ");
			double rating = Console.getDouble("Enter rating between 1 and 5 (decimals OK): ", 1.0, 5);
			Movie m = new Movie(title, year, rating);
			if (MovieDB.add(m)) {
				break;
			} else {
				Console.printLine("Error adding movie.");
			}

		}
	}

	public static void displayMenu() {
		Console.printLine("\n-----------------------");
		Console.printLine("What do you want to do?");
		Console.printLine("-----------------------");
		Console.printLine("1 - Enter a movie");
		Console.printLine("2 - View top rated movies");
		Console.printLine("3 - View most recent movies");
		Console.printLine("4 - View all movies");
		Console.printLine("5 - View ratings");
		Console.printLine("6 - Quit application");
	}

	private static void listMovies() {
		List<Movie> movies = MovieDB.getAll();
		for (Movie m : movies) {
			Console.printLine(m.toString());
		}
		Console.printLine("\n~~~~ menu repeats here ~~~~");
	}

	private static void getMoviesByTopRated() {
		List<Movie> movies = MovieDB.getAllByRating();
		for (Movie m : movies) {
			Console.printLine(m.toString());
		}
		Console.printLine("\n~~~~ menu repeats here ~~~~");
	}

	private static void getMostRecentMovie() {
		List<Movie> movies = MovieDB.getByMostRecent();
		for (Movie m : movies) {
			Console.printLine(m.toString());
		}
		Console.printLine("\n~~~~ menu repeats here ~~~~");
	}

	private static void getRatings() {
		List<Movie> movies = MovieDB.getLowestRating();
		for (Movie m : movies) {
			Console.printLine(m.toString());
		}
		Console.printLine("\n~~~~ menu repeats here ~~~~");
	}
}
