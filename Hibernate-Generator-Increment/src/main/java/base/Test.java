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
			e.setEid(555);// Not taken, Generated
			e.setEname("ZZZZZ");
			e.setEsal(999.999);
			
			Serializable s=ses.save(e);
			System.out.println((Integer)s);
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
