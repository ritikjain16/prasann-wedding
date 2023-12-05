package wedding.com.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wedding.com.exception.ResourceNotFoundException;
import wedding.com.model.Bookings;
import wedding.com.model.Users;
import wedding.com.service.BookingService;
import wedding.com.service.ServiceEventService;
import wedding.com.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private UserService userService;

	@Autowired
	ServiceEventService eventService;

	@PostMapping("/add/{user_id}")
	public ResponseEntity<Object> addBooking(@PathVariable("user_id") int user_id, @RequestBody Bookings booking)
			throws ResourceNotFoundException {

		Users u = userService.getUser(user_id);
		if (u == null)
			throw new ResourceNotFoundException("No user found with id " + user_id);

		Set<Bookings> bookings = u.getBookings();
		bookings.add(booking);

//		booking.setServices(booking.getServices()));

		Bookings b = bookingService.addBooking(booking);
		if (b != null) {
			return new ResponseEntity<Object>("Booking has been registered", HttpStatus.CREATED);
		}
		throw new ResourceNotFoundException("Something went wrong!");
	}

	@PatchMapping("/update")
	public ResponseEntity<Object> updateBooking(@RequestBody Bookings booking) throws ResourceNotFoundException {
//		System.out.println("kfhdkh");
//		System.out.println(booking);
		
		int nor = bookingService.updateStatus( booking.getStatus(),booking.getId());
		if(nor!=0) {
			return new ResponseEntity<Object>("Booking has been Updated to "+booking.getStatus(), HttpStatus.OK);
		}
		throw new ResourceNotFoundException("Something went wrong!");
	}

//	@GetMapping("/{booking_id}/service")
//	public ResponseEntity<Object> getServices(@PathVariable("booking_id") int bid,
//			@RequestBody List<Integer> serviceIds) throws ResourceNotFoundException {
//
//		
//		
//		throw new ResourceNotFoundException("Something went wrong!");
//	}

}
