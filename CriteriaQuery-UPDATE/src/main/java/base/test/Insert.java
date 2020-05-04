package base.test;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.Employee;
import base.HibernateUtil;

public class Insert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Employee e=new Employee();
			e.setEname("MMMM");
			e.setEsal(666.66);

			ses.save(e);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
