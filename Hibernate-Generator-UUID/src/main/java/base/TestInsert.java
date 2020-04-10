package base;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try {
			tx=ses.beginTransaction();
			
			Employee e=new Employee();
			e.setEid("HAY");// Not taken from here, Generated value taken
			e.setEname("GENERATED KEY");
			e.setEsal(12.55);
			
			Serializable se=ses.save(e);
			System.out.println((String)se);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
