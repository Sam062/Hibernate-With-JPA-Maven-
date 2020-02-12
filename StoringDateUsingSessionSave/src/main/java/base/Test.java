package base;

import java.io.Serializable;
import java.util.Date;

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

			Date d=new Date(System.currentTimeMillis());
			ModelClass mc=new ModelClass();
			mc.setProdId(101);
			mc.setProdName("ABC");
			mc.setMfgDate(d);
			mc.setExpDate(d);
			mc.setTestSlot(d);

			Serializable s=ses.save(mc);
			tx.commit();
			ses.close();
			System.out.println("Done! "+s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
