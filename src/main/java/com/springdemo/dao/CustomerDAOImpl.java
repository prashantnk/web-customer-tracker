package com.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {
//		create current session
//		create query and execute
		Session session = sessionFactory.getCurrentSession();
		Query<Customer> q = session.createQuery("select c from Customer c order by c.lastName desc", Customer.class);
		List<Customer> c = q.getResultList();
		return c;
	}

	@Override
	public void saveCustomer(Customer c) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(c);
	}

	@Override
	public Customer getCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		Customer c = session.get(Customer.class, customerId);
		return c;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(Customer.class, customerId));
		return;
	}

	@Override
	public List<Customer> searchCustomers(String name) {

		Session session = sessionFactory.getCurrentSession();

		String hql = "select c from Customer c where c.firstName LIKE :name OR c.lastName LIKE :name";

		Query<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("name", "%" + name + "%");

		List<Customer> c = query.getResultList();

		return c;
	}

}
