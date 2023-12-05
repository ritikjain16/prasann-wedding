package wedding.com.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import wedding.com.jpa.BookingRepository;
import wedding.com.model.Bookings;

@Repository
public class BookingDaoImpl implements BookingDao {

	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Bookings addBooking(Bookings booking) {
		Optional<Bookings> b = bookingRepository.findById(booking.getId());
		if (b.isEmpty()) {
			Bookings b1 = bookingRepository.save(booking);
			return b1;
		}
		return null;
	}

	@Transactional
	@Override
	public int updateStatus(String status, int id) {
		return bookingRepository.updateStatus(status, id);
	}

}
