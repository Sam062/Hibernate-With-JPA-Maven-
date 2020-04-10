package base;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction rx=null;
		try(ses) {
			rx=ses.beginTransaction();
			
			Employee e=new Employee();
			e.setEid(123);
			e.setEname("XXX");
			e.setEsal(455.55);
			
			Serializable s=ses.save(e);
			System.out.println((Integer)s);
			
			rx.commit();
		} catch (Exception e) {
			rx.rollback();
			e.printStackTrace();
		}
	}

}
