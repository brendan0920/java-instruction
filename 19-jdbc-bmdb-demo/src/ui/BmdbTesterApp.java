package ui;

import util.Console;
import java.time.LocalDate;
import java.util.List;
import db.ActorDB;
import db.MovieDB;
import model.Actor;
import model.Movie;

public class BmdbTesterApp {

	public static void main(String[] args) {
		
		Console.printLine("Welcome to the BMDB Tester App!");

		// Testing Movie
		Console.printLine("\nList all movies:");
		Console.printLine("================");
		listMovies();

		Console.printLine("\nAdd a movie:");
		Console.printLine("================");
		addMovie();
		
		Console.printLine("\nList all movies:");
		Console.printLine("================");
		listMovies();

		Console.printLine("\nGet a movie by id:");
		Console.printLine("================");
		getMovieById();

		Console.printLine("\nDelete a movie:");
		Console.printLine("================");
		deleteMovie();

		Console.printLine("\n================");
		Console.printLine("List all movies:");
		Console.printLine("================");
		listMovies();
		
		// =================================================================
		// Testing Actor
		Console.printLine("\n================");
		Console.printLine("List all actors:");
		Console.printLine("================");
		listActors();

		Console.printLine("\nAdd an actor:");
		Console.printLine("================");
		addActor();
		
		Console.printLine("\nList all actors:");
		Console.printLine("================");
		listActors();

		Console.printLine("\nGet an actor by id:");
		Console.printLine("================");
		getActorById();

		Console.printLine("\nDelete an actor:");
		Console.printLine("================");
		deleteActor();

		Console.printLine("\nList all actors:");
		Console.printLine("================");
		listActors();
		
		// =================================================================
		// Testing Credit

		Console.printLine("\nBye");
	}
	

	// Movie methods =======================================================
	private static void listMovies() {
		List<Movie> movies = MovieDB.getAll();
		for (Movie m : movies) {
			Console.printLine(m.toString());
		}
	}
	
	private static void addMovie() {
		String title = Console.getRequiredString("Title: ");
		int year = Console.getInt("Year: ");
		String rating = Console.getRequiredString("Rating: ");
		String director = Console.getRequiredString("Director: ");
		Movie m = new Movie(title, year, rating, director);
		if (MovieDB.add(m)) {
			Console.printLine("Movie added.");
		} else {
			Console.printLine("Error adding movie.");
		}
	}
	
	private static void getMovieById() {
		int id = Console.getInt("Movie Id: ");
		Movie m = MovieDB.get(id);
		if (m != null) {
			Console.printLine(m.toString());
		} else {
			Console.printLine("No movie found for id: " + id);
		}
	}
	
	private static void deleteMovie() {
		int id = Console.getInt("Movie Id: ");
		Movie m = MovieDB.get(id);
		if (m != null) {
			if (MovieDB.delete(id)) {
				Console.printLine("Movie deleted.");
			} else {
				Console.printLine("Error deleting movie.");
			}
		} else {
			Console.printLine("No movie found for id: " + id + ". Cannot delete.");
		}
	}
	
	
	// Actor methods =======================================================
	private static void listActors() {
		List<Actor> actors = ActorDB.getAll();
		for (Actor a : actors) {
			Console.printLine(a.toString());
		}
	}
	
	private static void addActor() {
		String fname = Console.getRequiredString("First Name: ");
		String lname = Console.getRequiredString("Last Name: ");
		String gender = Console.getRequiredString("Gender: ");
		LocalDate birthdate = Console.getRequiredLocalDate("Birthdate: ");
		Actor a = new Actor(fname, lname, gender, birthdate);
		if (ActorDB.add(a)) {
			Console.printLine("Actor added.");
		} else {
			Console.printLine("Error adding Actor.");			
		}
	}
	
	private static void getActorById() {
		int id = Console.getInt("Actor Id: ");
		Actor a = ActorDB.get(id);
		if (a != null) {
			Console.printLine(a.toString());
		} else {
			Console.printLine("No actor found for id: " + id);
		}
	}
	
	private static void deleteActor() {
		int id = Console.getInt("Actor Id: ");
		Actor a = ActorDB.get(id);
		if (a != null) {
			if (ActorDB.delete(id)) {
				Console.printLine("Actor deleted.");
			} else {
				Console.printLine("Error deleting actor.");
			}
		} else {
			Console.printLine("No actor found for id: " + id + ". Cannot delete.");
		}
	}
}
