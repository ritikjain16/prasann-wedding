package wedding.com.dao;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import wedding.com.jpa.UserRepository;
import wedding.com.model.Users;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository userRepository;

	@Override
	public String addUser(Users user) {
		Optional<Users> u = userRepository.findById(user.getId());
		if (u.isEmpty()) {
			Optional<Users> u1 = userRepository.findByEmail(user.getEmail());
			if (u1.isEmpty()) {
				String encrptedPassword = hashPassword(user.getPassword());
				user.setPassword(encrptedPassword);
				userRepository.save(user);
				return "Done";
			}
			return "Exist";
		}
		return "Exist";
	}

	@Override
	public Users getUser(int id) {
		Optional<Users> u = userRepository.findById(id);
		if (u.isPresent()) {
			return u.get();
		}
		return null;
	}

	@Override
	public Users loginUser(String email, String password) {
		Optional<Users> u = userRepository.findByEmail(email);
		if (u.isPresent()) {
			if (checkPass(password, u.get().getPassword()))
				return u.get();
		}
		return null;
	}

	@Override
	public String hashPassword(String plainTextPassword) {
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	public boolean checkPass(String plainPassword, String hashedPassword) {
		return BCrypt.checkpw(plainPassword, hashedPassword);

	}

	@Override
	public List<Users> getAllUsers() {
		return (List<Users>) userRepository.findAll();
	}

	@Transactional
	@Override
	public String updatePassword(String newPassword, String email, String oldPassword) {
		Optional<Users> u = userRepository.findByEmail(email);
		if (u.isPresent()) {
			if (checkPass(oldPassword, u.get().getPassword())) {
				String encrptedPassword = hashPassword(newPassword);
				int nor = userRepository.updatePassword(encrptedPassword, email);
				if (nor > 0) {
					return "Password Changed";
				} else {
					return "Unable to change Password!";
				}
			} else {
				return "Old Password not matched!";
			}
		}
		return "Something went wrong!";
	}

}
