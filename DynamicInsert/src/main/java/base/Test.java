package base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Configuration cfcg=new Configuration().configure();
		SessionFactory sf=cfcg.buildSessionFactory();
		Session ses=sf.openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			ModelClass mc=new ModelClass();
			mc.setEmopId(101);
			mc.setEmpSal(123.5);
			
			
			//If @DynamicInsert is applied on ModelClass then for null values no sql performed
			ses.save(mc);
			System.out.println("Done");
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
