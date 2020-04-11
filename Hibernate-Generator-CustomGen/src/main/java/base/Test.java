package base;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Employee e=new Employee();
			//e.setEid("AAA");
			e.setEname("ZZZ");
			e.setEsal(555.65);
			
			Serializable s=ses.save(e);
			System.out.println((String)s);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			
		}
	}

}
