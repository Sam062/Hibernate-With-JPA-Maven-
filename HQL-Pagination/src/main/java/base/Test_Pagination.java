package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_Pagination {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			int pageSize=5; //Max Rows are 5 in a page
			int pageNo=2; // by End user given 2 but in program index 1 is taken
			
			String hql=new StringBuilder("FROM "+Employee.class.getName()).toString();
			
			Query q=ses.createQuery(hql);
			q.setFirstResult((pageNo-1)*pageSize);
			q.setMaxResults(pageSize);
			
			List<Employee> l=q.list();
			
			for (Employee employee : l) {
				System.out.println(employee);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
