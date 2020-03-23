package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_BetweenOperator {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String hql="from base.Employee where eid between :a AND :b";

			Query<Employee> q=ses.createQuery(hql);
			q.setParameter("a", 101);
			q.setParameter("b", 104);

			List<Employee> l=q.list();
			l.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
