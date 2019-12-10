package data;

public class Trip {
	
	private int tripID;
	private String departure;
	private String arrival;
	private String time;
	private String date;
	private double price;
	private int seats;
	
	public Trip() {
	}
	
	public Trip(int tripID, String departure, String arrival, String time, String date, double price, int seats) {
		this.tripID = tripID;
		this.departure = departure;
		this.arrival = arrival;
		this.time = time;
		this.date = date;
		this.price = price;
		this.seats = seats;
	}

	public int getTripID() {
		return tripID;
	}

	public void setTripID(int tripID) {
		this.tripID = tripID;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}
}
