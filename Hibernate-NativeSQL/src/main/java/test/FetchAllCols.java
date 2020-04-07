package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

public class FetchAllCols {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String sql="SELECT * FROM EMPLOYEE";
			NativeQuery<Employee> nq=ses.createNativeQuery(sql, Employee.class);
			List<Employee> l=nq.list();
			
			l.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
