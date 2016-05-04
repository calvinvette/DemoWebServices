package com.weasley.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class MockCustomerDAO {
	private static Map<Long, Customer> customers;
	private static Long lastCustomerId = 0L;
	static {
		customers = new HashMap<>();

		Customer harry = new Customer();
		harry.setCustomerId(++lastCustomerId);
		harry.setFirstName("Harry");
		harry.setLastName("Potter");
		customers.put(harry.getCustomerId(), harry);
	}

	public Customer insert(Customer customer) {
		customer.setCustomerId(++lastCustomerId);
		customers.put(customer.getCustomerId(), customer);
		return customer;
	}

	public Customer update(Customer customer) {
		customers.put(customer.getCustomerId(), customer);
		return customer;
	}

	public Customer delete(Customer customer) {
		customers.remove(customer.getCustomerId());
		return customer;

	}

	public Customer findById(Long customerId) {
		return customers.get(customerId);
	}

	public List<Customer> findAll() {
		return new Vector<Customer>(customers.values());
	}

	public List<Customer> findByLastName(String lastName) {
		List<Customer> results = new ArrayList<>();
		for (Customer c : customers.values()) {
			if (c.getLastName().equalsIgnoreCase(lastName)) {
				results.add(c);
			}
		}
		return results;
	}
}
