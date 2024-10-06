package model;

public class User {
	private int id;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String phoneNumber;
	private String email;
	private boolean reviewer;
	private boolean admin;
	
	public User() {
		super();
	}

	public User(int id, String username, String password, String firstname, String lastname, String phoneNumber,
			String email, boolean reviewer, boolean admin) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.reviewer = reviewer;
		this.admin = admin;
	}
	
	public User(String username, String password, String firstname, String lastname, String phoneNumber,
			String email, boolean reviewer, boolean admin) {
		super();		
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.reviewer = reviewer;
		this.admin = admin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstname;
	}

	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastname;
	}

	public void setLastName(String lastname) {
		this.lastname = lastname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isReviewer() {
		return reviewer;
	}

	public void setReviewer(boolean reviewer) {
		this.reviewer = reviewer;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", phoneNumber=" + phoneNumber + ", email=" + email + ", reviewer="
				+ reviewer + ", admin=" + admin + "]";
	}
	
	
	
	
	
	

}
