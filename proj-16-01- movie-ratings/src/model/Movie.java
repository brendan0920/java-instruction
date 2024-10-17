package model;

import java.util.List;
import java.util.function.Predicate;

import db.MovieDB;

public class Movie {

	private int id;
	private String title;
	private int year;
	private double rating;
	private double lowestRating;
	private double highestRating;
	private double averageRating;
	private int size;
			
	public Movie(double lowestRating, double highestRating, double averageRating, int size) {
		super();
		this.lowestRating = lowestRating;
		this.highestRating = highestRating;
		this.averageRating = averageRating;
		this.size = size;
	}
	
	public Movie(int id, String title, int year, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.rating = rating;
	}

	public Movie(String title, int year, double rating) {
		super();
		this.title = title;
		this.year = year;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public Movie() {
		super();
	}

	public double getLowestRating() {
		return lowestRating;
	}

	public void setLowestRating(double lowestRating) {
		this.lowestRating = lowestRating;
	}

	public double getHighestRating() {
		return highestRating;
	}

	public void setHighestRating(double highestRating) {
		this.highestRating = highestRating;
	}

	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return title + "  (" + year + ") Rating: " + rating;
	}
	
	

	
	
//	public List<Movie> filterMovies(Predicate<Movie> condition){
//		
//	}
	
	
}
