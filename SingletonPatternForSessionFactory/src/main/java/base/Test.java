package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		
		Session ses=null;
		Transaction tx=null;
		try {
			ses=HibernateUtil.getSf().openSession();
			tx=ses.beginTransaction();
			
			ModelClass mc=new ModelClass();
			mc.setStdId(101);
			mc.setStdName("SAM");
			mc.setStdFee(12.4);
			
			ses.save(mc);
			
			tx.commit();
			System.out.println("done");
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		finally {
			if(ses!=null)
				ses.close();
		}
	}
}
