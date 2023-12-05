package wedding.com.service;


import java.util.List;

import wedding.com.model.Services;

public interface ServiceEventService {

	public List<Services> getAllServices();
	
	public Services getService(int id);
	
//	public boolean addCustomer(Services customer) throws ServiceEventException;
//
//	public List<Services> findByNameContaining(String name);
//
//	public int updateCustomerDet(String type, String status, int cid);
//
//	public int deleteByStatus(String status);

}
