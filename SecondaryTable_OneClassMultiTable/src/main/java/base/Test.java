package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			ModelClass mc=new ModelClass();
			mc.setEmpId(1234);
			mc.setEmpName("XYZ");
			mc.setEmpSal(123.55);
			mc.setEmpPrjs("NIT");
			mc.setEmpDept("ZZZ");
			ses.save(mc);
			
			System.out.println("DONE");
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
