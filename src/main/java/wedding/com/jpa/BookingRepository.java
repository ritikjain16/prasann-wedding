package wedding.com.jpa;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wedding.com.model.Bookings;


@Repository
public interface BookingRepository  extends CrudRepository<Bookings, Integer> {

	@Modifying
	
	@Query("update Bookings b set b.status=:status where id=:id")
	int updateStatus(@Param("status") String status,@Param("id") int id);
	
}
