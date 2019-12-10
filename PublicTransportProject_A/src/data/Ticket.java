package data;

public class Ticket {

	private int ticketNum;
	private String username;
	private int tripID;

	public Ticket(int ticketNum, String username, int tripID) {
		this.ticketNum = ticketNum;
		this.username = username;
		this.tripID = tripID;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getTripID() {
		return tripID;
	}

	public void setTripID(int tripID) {
		this.tripID = tripID;
	}
}
