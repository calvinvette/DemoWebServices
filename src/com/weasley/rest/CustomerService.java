package com.weasley.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class CustomerService {
	// TODO-CV @Inject the dao in later
	private CustomerDAO dao = new MockCustomerDAO();

	@POST
	public Customer insert(Customer customer) {
		return dao.insert(customer);
	}

	@PUT
	public Customer update(Customer customer) {
		return dao.update(customer);
	}

	@DELETE
	public Customer delete(Customer customer) {
		return dao.delete(customer);
	}

	// http://localhost:8080/DemoWebServices/rest/customers/1234
	@GET
	@Path("{id: \\d+}")
	public Customer findById(@PathParam("id") Long customerId) {
		return dao.findById(customerId);
	}

	@GET
	public List<Customer> findAll() {
		return dao.findAll();
	}

	// http://localhost:8080/DemoWebServices/rest/customers/lastName/Weasley
	@Path("/lastName/{lastName}")
	@GET
	public List<Customer> findByLastName(@PathParam("lastName") String lastName) {
		return dao.findByLastName(lastName);
	}
	
	// http://localhost:8080/DemoWebServices/rest/customers/email/harry.potter@hogwarts.ac.uk
	@GET
	@Path("/email/{email}")
	public List<Customer> findByEmail(@PathParam("email") String email) {
		return dao.findByEmail(email);
	}

	// http://localhost:8080/DemoWebServices/rest/customers/phone/+44 0206 555-1113
	@GET
	@Path("/phone/{phoneNumber}")
	public List<Customer> findByPhoneNumber(@PathParam("phoneNumber") String phoneNumber) {
		return dao.findByPhoneNumber(phoneNumber);
	}

	
	
}
