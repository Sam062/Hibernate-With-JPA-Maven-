package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			Student s1=new Student();
			s1.setSname("SAM");
			s1.setSfee(111.1);
			Student s2=new Student();
			s2.setSname("XXX");
			s2.setSfee(222.2);
			Student s3=new Student();
			s3.setSname("BBB");
			s3.setSfee(333.3);

			Project prj1=new Project();
			prj1.setPcode("IT");
			prj1.setPinfo("UNDER PROCESS");
			prj1.setStdObj(List.of(s1));

			Project prj2=new Project();
			prj2.setPcode("MAT");
			prj2.setPinfo("DONE");
			prj2.setStdObj(List.of(s3));
			s1.setPrObj(prj1);
			s3.setPrObj(prj2);

			ses.save(s1);
			ses.save(s2);
			ses.save(s3);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
