package wedding.com.controller;

import java.util.List;
import java.util.Map;

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
import wedding.com.model.Users;
import wedding.com.service.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<Object> addUser(@RequestBody Users user) throws ResourceNotFoundException {
		System.out.println(user);
		if (userService.addUser(user).equals("Done")) {
			return new ResponseEntity<Object>("User created", HttpStatus.OK);
		} else if (userService.addUser(user).equals("Exist")) {
			return new ResponseEntity<Object>("User with " + user.getEmail() + " already exists", HttpStatus.OK);
		}
		throw new ResourceNotFoundException("User already exists");
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Object> getUser(@PathVariable("id") int id) throws ResourceNotFoundException {
		Users u = userService.getUser(id);

		if (u != null) {
			u.setPassword("");
			return new ResponseEntity<Object>(u, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("User Not found");
	}

	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody Users user) throws ResourceNotFoundException {

		Users u = userService.loginUser(user.getEmail(), user.getPassword());

		if (u != null) {
			u.setPassword("************");
			return new ResponseEntity<Object>(u, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("User Not found");
	}

	@GetMapping("/get")
	public ResponseEntity<Object> getUsers() throws ResourceNotFoundException {
		List<Users> users = userService.getAllUsers();

		if (!users.isEmpty()) {

//			for(Users u:users) {
////				u.setPassword("");
////				System.out.println(u);
//				if(u.getUserType().equals("admin")) {
//					users.remove(u);
//				}
//			}

			return new ResponseEntity<Object>(users, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("User Not found");
	}

	@PatchMapping("/update/password")
	public ResponseEntity<Object> updatePassword(@RequestBody Map<String, String> m) throws ResourceNotFoundException {

		String res = userService.updatePassword(m.get("newPassword"), m.get("email"), m.get("oldPassword"));

		if (!res.equals("")) {
			return new ResponseEntity<Object>(res, HttpStatus.OK);
		}
		throw new ResourceNotFoundException("User Not found");
	}

}
