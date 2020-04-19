package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Employee1 e=new Employee1();
			e.setEid(101);
			e.setEname("DEMO");
			e.setEsal(123.4);			
			e.setProjects("NIT");
			e.setAddress("HYD");
			
			ses.save(e);
			
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
	}

}
