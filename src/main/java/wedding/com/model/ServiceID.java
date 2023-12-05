package wedding.com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ServiceID {
	@Id
	private int id;
	
	private int serviceId;
	
	
}
