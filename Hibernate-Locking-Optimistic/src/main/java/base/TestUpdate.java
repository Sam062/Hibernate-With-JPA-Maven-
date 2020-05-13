package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestUpdate {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();
			
			Student s=ses.get(Student.class, 1);
			System.out.println(s);
			
			s.setSname("XXX");
			ses.update(s);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
