package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_FetchAllColumns {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			
			//"from "+Employee.class.getName()
			//or "select e from base.Employee e"
			String hql="from "+Employee.class.getName();
			
			Query q=ses.createQuery(hql);
			
			List<Employee> out=q.list();
			
			out.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
