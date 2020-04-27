package base;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session ses=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Employee e=new Employee();
			e.setEid(101);
			e.setEname("A");
			e.setEsal(123.4);

			ses.save(e);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
