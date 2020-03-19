package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_FetchMultipleColumns {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String hql="select empName,empSal from "+Employee.class.getName();
			
			Query q=ses.createQuery(hql);
			
			List<Object[]> out=q.list();
			
			for (Object[] objects : out) {
				System.out.println(objects[0]+"--"+objects[1]);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
