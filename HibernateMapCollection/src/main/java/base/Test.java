package base;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		try {
			Configuration cf=new Configuration().configure();
			SessionFactory sf=cf.buildSessionFactory();
			Session ses=sf.openSession();
			Transaction tx=ses.beginTransaction();
			
			ModelClass mc=new ModelClass();
			mc.setCid(101);
			mc.setCname("SAM");
			mc.setAddr("HYD");
			
			Map<String,Double> mp=Map.of("P1",2.1,"P2",3.2,"P3",4.3);
			mc.setProjs(mp);
			
			ses.save(mc);	

			tx.commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
