package test;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;
public class NamedQueryFetch {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			Query<Employee> q=ses.createNamedQuery("allEmps");
			List<Employee> l=q.list();
			
			l.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
