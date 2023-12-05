package wedding.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wedding.com.dao.UserDao;
import wedding.com.model.Users;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public String addUser(Users user) {
		return userDao.addUser(user);
	}

	@Override
	public Users getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public Users loginUser(String email, String password) {
		return userDao.loginUser(email, password);
	}

	@Override
	public List<Users> getAllUsers() {
		return userDao.getAllUsers();
	}

	@Override
	public String updatePassword(String newPassword, String email, String oldPassword) {
		return userDao.updatePassword(newPassword, email, oldPassword);
	}

}
