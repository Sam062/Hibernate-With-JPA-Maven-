package base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
						
			ModelClass m1=ses.get(ModelClass.class, 102);
			m1.setEmpSal(5000.55);
			ses.update(m1);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}
}
