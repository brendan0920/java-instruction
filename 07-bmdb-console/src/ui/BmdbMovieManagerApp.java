package ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Movie;
import util.Console;

public class BmdbMovieManagerApp {

	public static void main(String[] args) {
		List<Movie> movies = new ArrayList<>();
		List<String> ratings = new ArrayList<> (Arrays.asList("G", "PG", "PG-13", "R", "NC-17"));
		
		Console.printLine("Welcome to the BMDB Movie Manager Application!");
		
		Movie m1 = new Movie(1, "test movie", 2024, "PG", "test director");
		System.out.println(m1);
		
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// Prompt a user for the fields of a movie: id, title, year, rating, director
			Console.printLine("Enter a movie: ");
			int id = Console.getInt("Id: ");
			String title = Console.getRequiredString("Title: ");
			int year = Console.getInt("Year: " );
			String rating = Console.getString("Rating: ", ratings);
			String director = Console.getRequiredString("Director: ");
			
			// Create an instance of Movie, store it in a List
			Movie m = new Movie(id, title, year, rating.toUpperCase(), director);
			movies.add(m);
			// Print list of movies
			Console.printLine("\nMovie: ");
			for (Movie movie: movies) {
				Console.printLine(movie.toString());
			}
			choice = Console.getString("Another movie?", new ArrayList<> (Arrays.asList("y", "n")));
			
		}
		
		
		
		
		System.out.println("Bye!");
	}

}
