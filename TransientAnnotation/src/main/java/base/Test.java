package base;

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
			ModelClass mc=new ModelClass();
			mc.setProductId(101);
			mc.setProductCode("ABC");
			mc.setProductCost(123.4);
			mc.setGst(10.5);
			
			ses.save(mc);
			tx.commit();
			ses.close();
			
			System.out.println(mc.getGst()+mc.getProductCost()+"done");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
