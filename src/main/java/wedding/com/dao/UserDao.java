package wedding.com.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;

import wedding.com.model.Users;

public interface UserDao {

	public String addUser(Users user);

	public Users getUser(int id);

	public Users loginUser(String email, String password);

	public String hashPassword(String plainTextPassword);

	public boolean checkPass(String plainPassword, String hashedPassword);

	public List<Users> getAllUsers();

	public String updatePassword(String newPassword, String email, String oldPassword);

}
