package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session ses=new Configuration().configure().buildSessionFactory().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Projects p=new Projects();
			p.setPid(101);
			p.setPname("AAA");
			p.setPrjs(List.of("A","XXX","YYY"));

			ses.save(p);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

	}
}
