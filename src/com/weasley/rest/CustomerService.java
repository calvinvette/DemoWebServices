package com.weasley.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.weasley.data.Customer;
import com.weasley.data.CustomerDAO;
import com.weasley.data.MockCustomerDAO;

// Server Root: http://localhost:8080/
// Context Root: http://localhost:8080/DemoWebServices/
// RESTful Services root (servlet-mapping for REST provider servlet):
// http://localhost:8080/DemoWebServices/rest
// @Path is appended to that:
// http://localhost:8080/DemoWebServices/rest/customers
@Path("/customers")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class CustomerService {
	// TODO-CV @Inject the dao in later
	private CustomerDAO dao = new MockCustomerDAO();

	public Customer insert(Customer customer) {
		return dao.insert(customer);
	}

	public Customer update(Customer customer) {
		return dao.update(customer);
	}

	public Customer delete(Customer customer) {
		return dao.delete(customer);
	}

	public Customer findById(Long customerId) {
		return dao.findById(customerId);
	}

	@GET
	public List<Customer> findAll() {
		return dao.findAll();
	}

//	http://localhost:8080/DemoWebServices/rest/customers/lastName/Weasley
	@Path("/lastName/{lastName}")
	@GET
	public List<Customer> findByLastName(@PathParam("lastName") String lastName) {
		return dao.findByLastName(lastName);
	}

	public List<Customer> findByEmail(String email) {
		return dao.findByEmail(email);
	}

	public List<Customer> findByPhoneNumber(String phoneNumber) {
		return dao.findByPhoneNumber(phoneNumber);
	}

	
}
