package db;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Actor;

public class ActorDB {
	
	private static Connection getConnection() throws SQLException {
		String dbURL = "jdbc:mysql://localhost:3306/bmdb";
		String username = "bmdb_user";
		String password = "sesame";
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		return connection;
	}
	
	// get all actors
	public static List<Actor> getAll() {
		String sql = "SELECT * FROM Actor";
		List<Actor> actors = new ArrayList<>();
		try {
			Connection conn = getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int id = rs.getInt(1);
				String fname = rs.getString(2);
				String lname = rs.getString(3);
				String gender = rs.getString(4);
				LocalDate birthdate = rs.getDate(5).toLocalDate();
				Actor a = new Actor(id, fname, lname, gender, birthdate);
				actors.add(a);
			}
			conn.close();
		}
		catch (SQLException e) {
			System.err.println(e);
			actors = null;
		}
		return actors;
	}
	
	// add an actor
	public static boolean add(Actor a) {
		String sql = "INSERT INTO actor (FirstName, LastName, Gender, Birthdate)"
				+ "Values (?, ?, ?, ?)";
		try (Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1,  a.getFname());
			ps.setString(2, a.getLname());
			ps.setString(3, a.getGender());
			ps.setDate(4,  Date.valueOf(a.getBirthDate()));
			ps.executeUpdate();
			return true;
		} 
		catch (SQLException e) {
			System.err.println(e);
			return false;
		}
	}
	
	// get am actor by id
	public static Actor get(int id) {
        String sql = "SELECT * "
                   + "FROM Actor "
                   + "WHERE Id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String fname = rs.getString(2);
                String lname = rs.getString(3);
                String gender = rs.getString(4);
                LocalDate birthdate = rs.getDate(5).toLocalDate();
                Actor a = new Actor(id, fname, lname, gender, birthdate);
                return a;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }
	
	// update an actor (* coded but not used in the app)
	public static boolean update(Actor a) {
        String sql = "UPDATE Actor SET "
                   + "  FirstName = ?, "
                   + "  LastName = ?, "
                   + "  Gender = ?, "
                   + "  Birthdate = ? "
                   + "WHERE Id = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
        	ps.setString(1,  a.getFname());
			ps.setString(2, a.getLname());
			ps.setString(3, a.getGender());
			ps.setDate(4,  Date.valueOf(a.getBirthDate()));
			ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
	
	// delete an actor by id
	public static boolean delete(int id) {
        String sql = "DELETE FROM Actor "
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
