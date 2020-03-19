package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_FetchOneColumn {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			
			String hql="select empName from "+Employee.class.getName();
			
			Query q=ses.createQuery(hql);
			
			List<String> out=q.list();
			
			out.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
