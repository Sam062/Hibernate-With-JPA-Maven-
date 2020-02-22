package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		
		try(ses) {
//			tx=ses.beginTransaction();
			
			
//			ModelClass mc=new ModelClass();
//			mc.setStdId(1234);
//			mc.setStdName("SAM");
//			mc.setStdFee(878.9);
//			
//			ses.save(mc);
			
			//-- ses.get(String fullClassName,Id)
			ModelClass mc1=(ModelClass)ses.get("base.ModelClass", 1234);
			//Or
			ModelClass mc2=(ModelClass)ses.get(ModelClass.class.getName(), 1234);
			
			System.out.println(mc1);
			System.out.println(mc2);
			
//			tx.commit();
		} catch (Exception e) {
//			tx.rollback();
			e.printStackTrace();
		}
	}

}
