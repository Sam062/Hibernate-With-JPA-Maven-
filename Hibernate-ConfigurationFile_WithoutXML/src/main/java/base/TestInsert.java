package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.util.HibernateUtil;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Student s=new Student(101,"SAM",123.4);
			
			ses.save(s);

			System.out.println("DONE");
			tx.commit();
		} catch (Exception e) {
			if(tx!=null&&tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

}
