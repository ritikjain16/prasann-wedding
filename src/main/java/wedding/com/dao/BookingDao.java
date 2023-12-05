package wedding.com.dao;

import java.util.List;



import wedding.com.model.Bookings;

public interface BookingDao {

	public Bookings addBooking(Bookings booking);
	
	public int updateStatus(String status, int id);
	
}
