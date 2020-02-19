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
			
			ses.delete(mc);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			if(ses!=null)
				ses.close();
			
		}
	}
}
