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
			
			Student s=new Student();
			s.setSid(101);
			s.setSname("AAA");
			s.setSmark(List.of(10,15,20,40));
			
			ses.save(s);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
