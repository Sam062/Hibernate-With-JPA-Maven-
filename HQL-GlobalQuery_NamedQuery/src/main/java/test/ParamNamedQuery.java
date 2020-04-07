package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;
import oracle.net.aso.l;

public class ParamNamedQuery {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			Query<Employee> q=ses.createNamedQuery("fetchEmps");
			q.setParameter("A", 102);
			
			List<Employee> e=q.list();
			
			e.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
