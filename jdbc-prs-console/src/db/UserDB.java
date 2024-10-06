package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDB {
	
	private static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/prsdb";
		String username = "prsdb_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		return connection;
	}
	
	// get all users
		public static List<User> getAll() {
			String sql = "SELECT * FROM User";
			List<User> users = new ArrayList<>();
			try {
				Connection conn = getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					int id = rs.getInt(1);
					String username = rs.getString(2);
					String password = rs.getString(3);
					String firstName = rs.getString(4);
					String lastName = rs.getString(5);
					String phoneNumber = rs.getString(6);
					String email = rs.getString(7);
					boolean reviewer = rs.getBoolean(8);
					boolean admin = rs.getBoolean(9);
					User u = new User(id, username, password, firstName, lastName, phoneNumber, email, reviewer, admin);
					users.add(u);
				}
				conn.close();
			}
			catch (SQLException e) {
				System.err.println(e);
				users = null;
			}
			return users;
		}
		
		// add an user
		public static boolean add(User u) {
			String sql = "INSERT INTO User (Username, Password, FirstName, LastName, PhoneNumber, Email, Reviewer, Admin)"
					+ "Values (?, ?, ?, ?, ?, ?, ?, ?)";
			try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
				ps.setString(1,  u.getUsername());
				ps.setString(2, u.getPassword());
				ps.setString(3, u.getFirstName());
				ps.setString(4,  u.getLastName());
				ps.setString(5,  u.getPhoneNumber());
				ps.setString(6,  u.getEmail());
				ps.setBoolean(7,  u.isReviewer());
				ps.setBoolean(8,  u.isAdmin());
				ps.executeUpdate();
				return true;
			} 
			catch (SQLException e) {
				System.err.println(e);
				return false;
			}
		}
		
		// get a user by id
		public static User get(int id) {
	        String sql = "SELECT * "
	                   + "FROM User "
	                   + "WHERE Id = ?";
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {	            	
					String username = rs.getString(2);
					String password = rs.getString(3);
					String firstName = rs.getString(4);
					String lastName = rs.getString(5);
					String phoneNumber = rs.getString(6);
					String email = rs.getString(7);
					boolean reviewer = rs.getBoolean(8);
					boolean admin = rs.getBoolean(9);
					User u = new User(id, username, password, firstName, lastName, phoneNumber, email, reviewer, admin);
	                return u;
	            } else {
	                rs.close();
	                return null;
	            }
	        } catch (SQLException e) {
	            System.err.println(e);
	            return null;
	        }
	    }
		
		// update an user (* coded but not used in the app)
		public static boolean update(User u) {
	        String sql = "UPDATE User SET "
	                   + "  Username = ?, "
	                   + "  Password = ?, "
	                   + "  FirstName = ?, "
	                   + "  LastName = ? "
	                   + "  PhoneNumber = ? "
	                   + "  Email = ? "
	                   + "  Reviewer = ? "
	                   + "  Admin = ? "
	                   + "WHERE Id = ?";
	        try (Connection connection = getConnection();
        		PreparedStatement ps = connection.prepareStatement(sql)) {
	        	ps.setString(1,  u.getUsername());
				ps.setString(2, u.getPassword());
				ps.setString(3, u.getFirstName());
				ps.setString(4,  u.getLastName());
				ps.setString(5,  u.getPhoneNumber());
				ps.setString(6,  u.getEmail());
				ps.setBoolean(7,  u.isReviewer());
				ps.setBoolean(8,  u.isAdmin());
	            ps.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            System.err.println(e);
	            return false;
	        }
	    }
		
		// delete an user by id
		public static boolean delete(int id) {
	        String sql = "DELETE FROM User "
	                   + "WHERE Id = ?";
	        try (Connection connection = getConnection();
	             PreparedStatement ps = connection.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	            return true;
	        } catch (SQLException e) {
	            System.err.println(e);
	            return false;
	        }
	    }	
	

}
