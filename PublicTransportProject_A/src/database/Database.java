package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {
	
	// connection parameters
	private static Connection con;
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/projectDatabase";
	private static final String USERNAME = "cis3270";
	private static final String PASSWORD = "ApplicationProgramming";

	// constructor method
	public Database() throws SQLException, ClassNotFoundException {

		Database.getConnection();

	}
	
	// creates connection
	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("Connected");
		} catch (Exception ex) {
			System.out.println(ex);
		}

		return con;

	}

	// add user to database
	public static void addUser(DataRetrieval data) throws SQLException {

		String query = "INSERT INTO projectdatabase.person (ssn, firstName, lastName, address, zip, state, username, password, email, secQuestion, secAnswer)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, data.getPerson().getSsn());
		stmt.setString(2, data.getPerson().getFirstName());
		stmt.setString(3, data.getPerson().getLastName());
		stmt.setString(4, data.getPerson().getAddress());
		stmt.setInt(5, data.getPerson().getZip());
		stmt.setString(6, data.getPerson().getState());
		stmt.setString(7, data.getPerson().getUsername());
		stmt.setString(8, data.getPerson().getPassword());
		stmt.setString(9, data.getPerson().getEmail());
		stmt.setString(10, data.getPerson().getSecQuestion());
		stmt.setString(11, data.getPerson().getSecAnswer());

		stmt.execute();

	}

	// look up and verify user login
	public static void login(String username, String password) throws SQLException {

		ResultSet rs;
		String query = "SELECT * FROM projectdatabase.person WHERE username = ? and password = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, username);
		stmt.setString(2, password);
		rs = stmt.executeQuery();
		
		if (!rs.next())
			System.out.println("Enter Correct Username or Password");
		else
			System.out.println("Login Successful");		
		
	}

	// verify security question and answer and retrieve password
	public static void verifySecQuestion(DataRetrieval data) throws Exception {

		ResultSet rs;
		String query = "SELECT secAnswer FROM projectdatabase.person WHERE secQuestion = ? and email = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, data.getPerson().getSecQuestion());
		stmt.setString(2, data.getPerson().getEmail());
		rs = stmt.executeQuery();

		while (rs.next()) {
			// check security question
			if (!rs.getString("secAnswer").equalsIgnoreCase(data.getPerson().getSecAnswer())) {
				// incorrect answer
				throw new SQLException("Incorrect Answer");
			}
		}

		// retrieve password
		query = "SELECT password FROM projectdatabase.person WHERE secQuestion = ? and email = ?";
		stmt = con.prepareStatement(query);
		stmt.setString(1, data.getPerson().getSecQuestion());
		stmt.setString(2, data.getPerson().getEmail());
		rs = stmt.executeQuery();

		while (rs.next()) {
			throw new SQLException("Your password is " + rs.getString("password"));
		}
	}

	// book a bus ticket
	public static void reserveTrip(DataRetrieval data) throws SQLException {

		ResultSet rs;
		int userSSN = 0;

		// look up user
		String query = "SELECT ssn FROM projectdatabase.person WHERE username = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, data.getTicket().getUsername());
		rs = stmt.executeQuery();
		while (rs.next()) {
			userSSN = Integer.parseInt(rs.getString("ssn"));
		}

		// reserve trip
		query = "INSERT INTO projectdatabase.ticket (ticketNum, ssn, tripID, username) VALUES (?, ?, ?, ?)";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, data.getTicket().getTicketNum());
		stmt.setInt(2, userSSN);
		stmt.setInt(3, data.getTicket().getTripID());
		stmt.setString(4, data.getTicket().getUsername());

		// throw exception if trip is already booked by user
		try {
			stmt.execute();
		} catch (SQLException ex) {
			throw new SQLException("You already hold this reservation");
		}

		// update number of available seats in database
		query = "UPDATE projectdatabase.trip SET seats = seats - 1 WHERE (tripID = ?)";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, data.getTicket().getTripID());
		stmt.execute();

	}

	// cancel bus ticket
	public static void cancelTrip(DataRetrieval data) throws SQLException {

		String query = "DELETE FROM projectdatabase.ticket WHERE tripID = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, data.getTicket().getTripID());
		stmt.executeUpdate();

		// update number of available seats in database
		query = "UPDATE projectdatabase.trip SET seats = seats + 1 WHERE (tripID = ?)";
		stmt = con.prepareStatement(query);
		stmt.setInt(1, data.getTicket().getTripID());
		stmt.executeUpdate();

	}

	// admin accessible only - add trip to database
	public static void addTrip(DataRetrieval data) throws SQLException {

		String query = "INSERT INTO projectdatabase.trip (tripID, departure, arrival, time, date, price, seats)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, data.getTrip().getTripID());
		stmt.setString(2, data.getTrip().getDeparture());
		stmt.setString(3, data.getTrip().getArrival());
		stmt.setString(4, data.getTrip().getTime());
		stmt.setString(5, data.getTrip().getDate());
		stmt.setDouble(6, data.getTrip().getPrice());
		stmt.setInt(7, data.getTrip().getSeats());

		try {
			stmt.execute();
		} catch (SQLException ex) {
			throw new SQLException("Trip already exists");
		}
	}

	// admin accessible only - edit trip details in database
	public static void editTrip(DataRetrieval data) throws SQLException {

		String query = "UPDATE projectdatabase.trip SET price = ?, seats = ? WHERE (tripid = ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setDouble(1, data.getTrip().getPrice());
		stmt.setInt(2, data.getTrip().getSeats());
		stmt.setInt(3, data.getTrip().getTripID());
		stmt.executeUpdate();

	}

	// admin accessible only - delete trip from database
	public static void deleteTrip(DataRetrieval data) throws SQLException {

		String query = "DELETE FROM trip WHERE (tripID = ?)";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setInt(1, data.getTrip().getTripID());
		stmt.executeUpdate();

	}

	public static void closeConnection() throws SQLException {

		con.close();
		System.out.println("Connection Closed");

	}
}
