package base;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		try {
			Configuration cfg=new Configuration().configure();
			SessionFactory sf=cfg.buildSessionFactory();
			Session ses=sf.openSession();
			Transaction tx=ses.beginTransaction();
			
			ModelClass mc=new ModelClass();
			mc.setEid(101);
			mc.setEname("SAM");
			
			Set<String> set=Set.of("NIT","HTC","TCS");
			mc.setPrj(set);
			
			ses.save(mc);
			
			tx.commit();
			System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
