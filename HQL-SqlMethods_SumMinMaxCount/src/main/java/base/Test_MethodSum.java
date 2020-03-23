package base;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_MethodSum {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSfg().openSession();
		try(ses) {
			String hql="select sum(empSal) from base.Employee";

			Query<Employee> q=ses.createQuery(hql);

			Object ob=q.uniqueResult();
			Double sum=(Double)ob;

			System.out.println(sum);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
