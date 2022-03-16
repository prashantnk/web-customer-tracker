package com.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.CustomerDAO;
import com.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer c) {
		customerDAO.saveCustomer(c);
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int customerId) {
		customerDAO.deleteCustomer(customerId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String name) {
		return customerDAO.searchCustomers(name);
	}
}
