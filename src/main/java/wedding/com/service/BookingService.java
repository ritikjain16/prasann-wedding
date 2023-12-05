package wedding.com.service;

import wedding.com.model.Bookings;

public interface BookingService {
	public Bookings addBooking(Bookings booking);
	public int updateStatus(String status, int id);
}
