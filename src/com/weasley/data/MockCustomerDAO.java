package com.weasley.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MockCustomerDAO implements CustomerDAO {
	private static Map<Long, Customer> customers;
	private static Map<String, List<Customer>> customersByLastName;
	private static Map<String, List<Customer>> customersByPhoneNumber;
	private static Map<String, List<Customer>> customersByEmail;

	private static Long lastCustomerId = 0L;

	private static Customer addCustomer(Customer customer) {
		customer.setCustomerId(++lastCustomerId);
		return updateCustomer(customer);
	}

	private static Customer updateCustomer(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
		customersByLastName.get(customer.getLastName().toLowerCase()).add(customer);
		customersByPhoneNumber.get(customer.getPhoneNumber().toLowerCase()).add(customer);
		customersByEmail.get(customer.getEmail().toLowerCase()).add(customer);
		return customer;
	}

	public static Customer deleteCustomer(Customer customer) {
		customers.remove(customer.getCustomerId());
		customersByLastName.get(customer.getLastName().toLowerCase()).remove(customer);
		customersByPhoneNumber.get(customer.getPhoneNumber().toLowerCase()).remove(customer);
		customersByEmail.get(customer.getEmail().toLowerCase()).remove(customer);
		return customer;
	}

	static {
		customers = new HashMap<>();
		customersByLastName = new HashMap<>();

		addCustomer(new Customer("Harry", "Potter", "+44 0206 555-1113", "harry.potter@hogwarts.ac.uk"));
		addCustomer(new Customer("Ron", "Weasley", "+44 0206 555-1314", "ron.weasley@hogwarts.ac.uk"));
		addCustomer(new Customer("Hermions", "Granger", "+44 0206 555-41145", "hermione.granger@hogwarts.ac.uk"));

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weasley.data.CustomerDAO#insert(com.weasley.data.Customer)
	 */
	@Override
	public Customer insert(Customer customer) {
		return addCustomer(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weasley.data.CustomerDAO#update(com.weasley.data.Customer)
	 */
	@Override
	public Customer update(Customer customer) {
		return updateCustomer(customer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weasley.data.CustomerDAO#delete(com.weasley.data.Customer)
	 */
	@Override
	public Customer delete(Customer customer) {
		return deleteCustomer(customer);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weasley.data.CustomerDAO#findById(java.lang.Long)
	 */
	@Override
	public Customer findById(Long customerId) {
		return customers.get(customerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weasley.data.CustomerDAO#findAll()
	 */
	@Override
	public List<Customer> findAll() {
		return new Vector<Customer>(customers.values());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.weasley.data.CustomerDAO#findByLastName(java.lang.String)
	 */
	@Override
	public List<Customer> findByLastName(String lastName) {
		// List<Customer> results = new ArrayList<>();
		// for (Customer c : customers.values()) {
		// if (c.getLastName().equalsIgnoreCase(lastName)) {
		// results.add(c);
		// }
		// }
		// return results;
		return customersByLastName.get(lastName.toLowerCase());
	}

	@Override
	public List<Customer> findByPhoneNumber(String phoneNumber) {
		return customersByPhoneNumber.get(phoneNumber.toLowerCase());
	}

	@Override
	public List<Customer> findByEmail(String email) {
		return customersByEmail.get(email.toLowerCase());
	}

}
