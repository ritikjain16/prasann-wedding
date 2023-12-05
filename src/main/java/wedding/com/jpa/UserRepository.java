package wedding.com.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wedding.com.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users,Integer>{

	public Optional<Users> findByEmail(String email);
	
	@Modifying
	@Query("update Users u set u.password=:password where u.email=:email")
	int updatePassword(@Param("password") String newPassword,@Param("email")String email);
	
}
