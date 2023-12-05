package wedding.com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import wedding.com.jpa.ServiceEventRepository;
import wedding.com.model.Services;

@Repository
public class ServiceEventDaoImpl implements ServiceEventDao {

	@Autowired
	ServiceEventRepository eventRepository;

	@Override
	public List<Services> getAllServices() {
		return (List<Services>) eventRepository.findAll();
	}

	@Override
	public Services getService(int id) {
		Optional<Services> s = eventRepository.findById(id);
		if (s.isPresent()) {
			return s.get();
		}
		return null;
	}

}
