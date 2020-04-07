package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

public class NormalFetch {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String hql="FROM "+Employee.class.getName();
			Query q=ses.createQuery(hql);
			
			List<Employee> l=q.list();
			
			l.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
