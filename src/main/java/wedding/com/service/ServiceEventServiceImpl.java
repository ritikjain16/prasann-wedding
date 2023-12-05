package wedding.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wedding.com.dao.ServiceEventDao;
import wedding.com.model.Services;

@Service
public class ServiceEventServiceImpl implements ServiceEventService {

	@Autowired
	ServiceEventDao eventDao;

	@Override
	public List<Services> getAllServices() {
		return eventDao.getAllServices();
	}

	@Override
	public Services getService(int id) {
		return eventDao.getService(id);
	}

//	@Override
//	public boolean addCustomer(Services customer) throws ServiceEventException {
//		if (customer.getDor() == null) {
//			Date d = new Date();
//			customer.setDor(d);
//		}
//		if (customer.getType() == null)
//			customer.setType("silver");
//		if (customer.getStatus() == null)
//			customer.setStatus("active");
//
//		return customerDao.addCustomer(customer);
//	}
//
//	@Override
//	public List<Services> findByNameContaining(String name) {
//		return customerDao.findByNameContaining(name);
//	}
//
//	@Override
//	public int updateCustomerDet(String type, String status, int cid) {
//		return customerDao.updateCustomerDet(type, status, cid);
//	}
//
//	@Override
//	public int deleteByStatus(String status) {
//		return customerDao.deleteByStatus(status);
//	}

}
