package base;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		
		try(ses) {
			tx=ses.beginTransaction();
			Course c1=new Course(121, "HIB", 20.2);
			Course c2=new Course(131, "SPR", 50.2);
			Course c3=new Course(141, "BOOT", 100.2);
			
			Student s1=new Student();
			s1.setStdId(10);
			s1.setStdNAme("A");
			s1.setStdMail("a@mail");
			s1.setObs(Arrays.asList(c1,c2));
			
			Student s2=new Student();
			s2.setStdId(20);
			s2.setStdNAme("B");
			s2.setStdMail("b@mail");
			s2.setObs(Arrays.asList(c2,c3));
			
			ses.save(s1);
			ses.save(s2);
			ses.save(c1);
			ses.save(c2);
			ses.save(c3);
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
