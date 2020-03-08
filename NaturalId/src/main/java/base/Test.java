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
			
//			ModelClass mc=new ModelClass();
//			mc.setEid(969565);
//			mc.setEcode("ORCL1521");
//			ses.save(mc);
			
//			ModelClass m=ses.get(ModelClass.class, 969565);
			ModelClass m=ses.bySimpleNaturalId(ModelClass.class).load("ORCL1521");
			System.out.println(m);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
