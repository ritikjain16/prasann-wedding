package wedding.com.dao;

import java.util.List;

import wedding.com.model.Services;

public interface ServiceEventDao {

//	public boolean addCustomer(Services customer);
//
	public List<Services> getAllServices();
	
	public Services getService(int id);
//
//	public int updateCustomerDet(String type, String status, int cid);
//
//	public int deleteByStatus(String status);

}
