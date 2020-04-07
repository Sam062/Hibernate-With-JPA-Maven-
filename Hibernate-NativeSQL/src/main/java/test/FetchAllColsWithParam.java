package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import base.Employee;
import base.HibernateUtil;

public class FetchAllColsWithParam {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String sql="SELECT * FROM EMPLOYEE WHERE EID>=:A";
			NativeQuery q=ses.createSQLQuery(sql).addEntity(Employee.class);
			q.setParameter("A", 102);
			
			List<Employee> l=q.list();

			l.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
