package base;

import java.util.List;

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
			mc.setStdid(101);
			mc.setStdName("ABC");
			
			List<Double> li=List.of(123.4,1234.5,258.9);
			mc.setMarks(li);
			
			ses.save(mc);
			
			tx.commit();
			System.out.println("done");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
