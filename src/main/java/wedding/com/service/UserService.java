package wedding.com.service;

import java.util.List;

import wedding.com.model.Users;

public interface UserService {

	public String addUser(Users user);

	public Users getUser(int id);

	public Users loginUser(String email, String password);

	public List<Users> getAllUsers();

	public String updatePassword(String newPassword, String email, String oldPassword);
}
