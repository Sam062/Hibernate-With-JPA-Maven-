package base.dao;

import java.util.List;

import base.Customer;

public interface ICustomerDAO {
	public Integer saveCustmer(Customer c);
	public List<Customer> getAllCustomers();
	public Customer getOneCustomer(Integer id);
	public StringBuilder updateCustomer(Customer c);
}
