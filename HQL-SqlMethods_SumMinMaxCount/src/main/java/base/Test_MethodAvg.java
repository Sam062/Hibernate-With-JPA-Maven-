package base;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_MethodAvg {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSfg().openSession();
		try(ses) {
			String hql="select avg(empSal) from base.Employee";
			
			Query<Employee> q=ses.createQuery(hql);
			Object ob=q.uniqueResult();
			Double avg=(Double)ob;
			
			System.out.println(avg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
