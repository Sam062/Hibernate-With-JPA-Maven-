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
			
			ModelClass mc1=ses.load(ModelClass.class, 1234);
			
			//or one more way-- ses.get(fullClassName,Id)
			//ModelClass mc2=(ModelClass)ses.get(ModelClass.class.getName(),1234);
			
			//or one more way--
			//ModelClass mc3=(ModelClass)ses.get(Class.forName(ModelClass.class.getName()), 1234);
			System.out.println("Before Using The Object-----" +mc1.getStdId());
			
			
			System.out.println("Now Using Object");
			System.out.println(mc1);
			//System.out.println(mc2);
			//System.out.println(mc3);
			
			
//			tx.commit();
		} catch (Exception e) {
//			tx.rollback();
			e.printStackTrace();
		}
	}

}
