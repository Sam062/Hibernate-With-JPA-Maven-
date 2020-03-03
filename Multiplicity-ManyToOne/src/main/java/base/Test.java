package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Quote qt=new Quote();
			qt.setQteId(501);
			qt.setQteMinAmt(30.0);
			qt.setQteCode("RTM");
			
			Contract ct=new Contract();
			ct.setCntId(10);
			ct.setVendor("A");
			ct.setCntCode("a1");
			ct.setQob(qt);
			
			Contract ct1=new Contract();
			ct1.setCntId(11);
			ct1.setVendor("B");
			ct1.setCntCode("b1");
			ct1.setQob(qt);
			
			Contract ct2=new Contract();
			ct2.setCntId(12);
			ct2.setVendor("C");
			ct2.setCntCode("c1");
			ct2.setQob(qt);
			
			ses.save(qt);
			ses.save(ct);
			ses.save(ct1);
			ses.save(ct2);
			
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
