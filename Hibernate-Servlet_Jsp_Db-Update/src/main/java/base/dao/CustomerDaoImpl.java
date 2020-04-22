package base.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.Customer;
import base.util.HibernateUtil;

public class CustomerDaoImpl implements ICustomerDAO{
	@Override
	public Integer saveCustmer(Customer c) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Integer id=null;
		try(ses) {
			tx=ses.beginTransaction();

			id=(Integer)ses.save(c);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return id;
	}
	@Override
	public List<Customer> getAllCustomers() {
		Session ses=HibernateUtil.getSf().openSession();
		List<Customer> list=null;
		try {
			list=ses.createQuery("FROM "+Customer.class.getName()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public StringBuilder updateCustomer(Customer c) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		StringBuilder msg=null;
		try(ses) {
			tx=ses.beginTransaction();

			ses.update(c);

			tx.commit();
			msg=new StringBuilder().append("Updated ").append(c.getCname()).append(" Details.");
		} catch (Exception e) {
			tx.rollback();
			msg=new StringBuilder("Customer ").append(c.getCname()+c.getCid()).append(" Not Exist!!");
			e.printStackTrace();
		}
		return msg;
	}
	@Override
	public Customer getOneCustomer(Integer id) {
		Session ses=HibernateUtil.getSf().openSession();
		Customer c=null;
		try {
			c=ses.get(Customer.class, id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
}
