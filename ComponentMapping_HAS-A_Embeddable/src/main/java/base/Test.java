package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Address ad=new Address();
			ad.setHno(999);
			ad.setLoc("HYD");
			
			Employee emp=new Employee();
			emp.setEid(121);
			emp.setEname("SAM");
			emp.setAddr(ad);
			
			ses.save(emp);
			System.out.println("DONE");
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
