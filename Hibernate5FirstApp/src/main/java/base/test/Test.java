package base.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import base.ModelClass;

public class Test {
	public static void main(String[] args) {
		ModelClass mod=new ModelClass();
		mod.setStdId(1111);
		mod.setStdName("SAMMM");
		mod.setSdtFee(1234.41);

		try {
			//Creating Configuration(C) Object
			Configuration cfg=new Configuration();
			//Loading cfg.xml
			cfg.configure();
			//Building SessionFactory
			SessionFactory sf=cfg.buildSessionFactory();
			//Opening Session
			Session ses=sf.openSession();
			//Performing Operation
			ses.save(mod);
			//Begin Transaction
			Transaction t=ses.beginTransaction();
			//commit
			t.commit();
			//closing session
			ses.close();
			System.out.println("Done !!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
