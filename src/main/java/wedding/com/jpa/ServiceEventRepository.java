package wedding.com.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import wedding.com.model.Services;

@Repository
public interface ServiceEventRepository extends CrudRepository<Services, Integer> {

//	List<Services> findByNameContaining(String name);
//
//	@Modifying
//	@Query("update Customer c set c.type=:type, c.status=:status where c.cid=:cid")
//	int updateCustomerDet(@Param("type") String type, @Param("status") String status, @Param("cid") int cid);
//
//	@Modifying
//	@Query("delete Customer c where c.status=:status")
//	int deleteByStatus(@Param("status") String status);

}
