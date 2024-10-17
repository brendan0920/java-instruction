package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Movie;

public class MovieDB {

	private static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/movieratingdb";
		String username = "movieratingdb_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		return connection;
	}
	
	// get all movies
	public static List<Movie> getAll() {
		String sql = "SELECT * FROM Movie";
		List<Movie> movies = new ArrayList<>();
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				int year = rs.getInt(3);
				double rating = rs.getDouble(4);
				
				Movie m = new Movie(id, title, year, rating);
				movies.add(m);
			}
			conn.close();
		}
		catch (SQLException e) {
			System.err.println(e);
			movies = null;
		}
		return movies;
	}
	
	// add a movie
	public static boolean add(Movie m) {
		String sql = "INSERT INTO movie (Title, Year, Rating)"
				+ "Values (?, ?, ?)";
		try (Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1,  m.getTitle());
			ps.setInt(2, m.getYear());
			ps.setDouble(3, m.getRating());			
			ps.executeUpdate();
			return true;
		} 
		catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	// get all movies by rating where rating >= 4.0
	public static List<Movie> getAllByRating() {
        String sql = "SELECT * "
                   + "FROM Movie "
                   + "WHERE Rating >= 4.0"
                   + "ORDER BY Rating DESC";
        List<Movie> movies = new ArrayList<>();
        try {
        	Connection conn = getConnection();
    		Statement stmt = conn.createStatement(); 
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
            	int id = rs.getInt(1);
                String title = rs.getString(2);
                int year = rs.getInt(3);
                double rating = rs.getDouble(4);                
                
                Movie m = new Movie(id, title, year, rating);
                movies.add(m);
            }
            conn.close();
        } catch (SQLException e) {
            System.err.println(e);
            movies = null;
        }
        return movies;
    }
	

	// get the most recent movie
		public static List<Movie> getByMostRecent() {
	        String sql = "SELECT * "
	                   + "FROM Movie "	                   
	                   + "ORDER BY Year DESC "
	                   + "LIMIT 1";
	        List<Movie> movies = new ArrayList<>();
	        try {
	        	Connection conn = getConnection();
	    		Statement stmt = conn.createStatement(); 
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	            	int id = rs.getInt(1);
	                String title = rs.getString(2);
	                int year = rs.getInt(3);
	                double rating = rs.getDouble(4);                
	                
	                Movie m = new Movie(id, title, year, rating);
	                movies.add(m);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            System.err.println(e);
	            movies = null;
	        }
	        return movies;
	    }
	
		
		public static List<Movie> getLowestRating() {
	        String sql = "SELECT MIN(Rating) AS lowest_rating "
	                   + "FROM Movie "; 
	        List<Movie> movies = new ArrayList<>();
	        try {
	        	Connection conn = getConnection();
	    		Statement stmt = conn.createStatement(); 
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	            	int id = rs.getInt(1);
	                String title = rs.getString(2);
	                int year = rs.getInt(3);
	                double rating = rs.getDouble(4);                
	                
	                Movie m = new Movie(id, title, year, rating);
	                movies.add(m);
	            }
	            conn.close();
	        } catch (SQLException e) {
	            System.err.println(e);
	            movies = null;
	        }
	        return movies;
	    }
	
		

}
