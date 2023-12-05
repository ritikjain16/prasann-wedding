package wedding.com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import wedding.com.exception.ResourceNotFoundException;
import wedding.com.model.Bookings;
import wedding.com.model.Services;
import wedding.com.service.ServiceEventException;
import wedding.com.service.ServiceEventService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/services")
public class ServiceEventController {

	@Autowired
	ServiceEventService eventService;

	@GetMapping("")
	public String welcome() {
		return "welcome to wedding app";
	}

	@GetMapping("/get")
	public ResponseEntity<Object> getServices() throws ResourceNotFoundException {
		List<Services> s = eventService.getAllServices();
		if (!s.isEmpty()) {
			return new ResponseEntity<Object>(s, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("No Services found");
	}

	@PostMapping("/getbylist")
	public ResponseEntity<Object> getServices(@RequestBody Bookings b) throws ResourceNotFoundException {

		List<Services> servicesList = new ArrayList<>();

		for (Integer s : b.getServices()) {
			Services s1 = eventService.getService(s);
			if (s1 != null)
				servicesList.add(s1);
		}

		if (!servicesList.isEmpty()) {
			return new ResponseEntity<Object>(servicesList, HttpStatus.FOUND);
		}

		throw new ResourceNotFoundException("Something went wrong!");
	}

//	@PostMapping("/add")
//	public String addCustomer(@RequestBody Services customer) throws ServiceEventException {
//
//		if (customerService.addCustomer(customer)) {
//			return "Customer Added Successfully";
//		}
//		return "Something went wrong! May be customer already exist";
//	}
//
//	@GetMapping("/name/{name}")
//	public ResponseEntity<Object> findByName(@PathVariable("name") String name) throws ResourceNotFoundException {
//		List<Services> c = customerService.findByNameContaining(name);
//		if (!c.isEmpty()) {
//			return new ResponseEntity<Object>(c, HttpStatus.FOUND);
//		}
//		throw new ResourceNotFoundException("No customer found");
//	}
//
//	@PutMapping("/update")
//	public ResponseEntity<Object> update(@RequestBody Services customer) throws ResourceNotFoundException {
//		int nor = customerService.updateCustomerDet(customer.getType(), customer.getStatus(), customer.getCid());
//		if (nor > 0) {
//			return new ResponseEntity<Object>(nor + " record updated", HttpStatus.FOUND);
//		}
//		throw new ResourceNotFoundException("Something went wrong! May be customer not exist.");
//	}
//
//	@DeleteMapping("/{status}")
//	public ResponseEntity<Object> delete(@PathVariable("status") String status) throws ResourceNotFoundException {
//		int nor = customerService.deleteByStatus(status);
//
//		if (nor > 0) {
//			return new ResponseEntity<Object>(" Total " + nor + " records deleted successfully which are " + status,
//					HttpStatus.FOUND);
//		}
//		throw new ResourceNotFoundException("Something went wrong! May be customer not exist.");
//	}

}
