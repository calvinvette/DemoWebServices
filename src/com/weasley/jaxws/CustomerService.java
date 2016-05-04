package com.weasley.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.weasley.data.Customer;
import com.weasley.data.CustomerDAO;
import com.weasley.data.MockCustomerDAO;

@WebService(targetNamespace="http://weasley.com/CustomerService")
public class CustomerService {
	// TODO-CV - @Inject the dao
	private CustomerDAO dao = new MockCustomerDAO();

	@WebMethod
	public Customer insert(@WebParam(name="customer") Customer customer) {
		return dao.insert(customer);
	}

	@WebMethod
	public Customer update(@WebParam(name="customer") Customer customer) {
		return dao.update(customer);
	}

	@WebMethod
	public Customer delete(@WebParam(name="customer") Customer customer) {
		return dao.delete(customer);
	}

	@WebMethod
	public Customer findById(@WebParam(name="customerId") Long customerId) {
		return dao.findById(customerId);
	}

	@WebMethod
	public List<Customer> findAll() {
		return dao.findAll();
	}

	@WebMethod
	public List<Customer> findByLastName(@WebParam(name="lastName") String lastName) {
		return dao.findByLastName(lastName);
	}

	@WebMethod
	public List<Customer> findByEmail(@WebParam(name="email") String email) {
		return dao.findByEmail(email);
	}

	@WebMethod
	public List<Customer> findByPhoneNumber(@WebParam(name="phoneNumber") String phoneNumber) {
		return dao.findByPhoneNumber(phoneNumber);
	}
	
	

}
