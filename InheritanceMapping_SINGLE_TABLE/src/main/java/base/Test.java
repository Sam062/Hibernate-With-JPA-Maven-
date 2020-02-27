package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Person pob=new Person();
			pob.setPerId(10);
			pob.setPerName("A");
			
			Employee eob=new Employee();
			eob.setPerId(11);
			eob.setPerName("B");
			eob.setEmpSal(1.2);
			eob.setEmpDept("DEV");
			
			Student sob=new Student();
			sob.setPerId(12);
			sob.setPerName("C");
			sob.setStdFee(2.2);
			sob.setStdGrd("X");
			
			ses.save(pob);
			ses.save(sob);
			ses.save(eob);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
