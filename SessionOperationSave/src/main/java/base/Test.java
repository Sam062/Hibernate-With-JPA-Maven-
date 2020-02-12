package base;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		try {
			Configuration cfg=new Configuration();
			cfg.configure();

			SessionFactory sf=cfg.buildSessionFactory();
			Session ses=sf.openSession();
			Transaction tx=ses.beginTransaction();

			ModelClassCustomer mc=new ModelClassCustomer();
			mc.setCustId(101);
			mc.setCustName("SAM");
			mc.setCustSal(123.4);

			Serializable id=ses.save(mc);
			tx.commit();
			ses.close();
			
			System.out.println("Done !, Id is " +id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
