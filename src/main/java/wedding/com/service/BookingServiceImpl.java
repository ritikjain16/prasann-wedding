package wedding.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wedding.com.dao.BookingDao;
import wedding.com.model.Bookings;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public Bookings addBooking(Bookings booking) {
		return bookingDao.addBooking(booking);
	}

	@Override
	public int updateStatus(String status, int id) {
		return bookingDao.updateStatus(status, id);
	}

}
