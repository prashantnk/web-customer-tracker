package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer c);

	public Customer getCustomer(int customerId);

	public void deleteCustomer(int customerId);

	public List<Customer> searchCustomers(String name);

}
