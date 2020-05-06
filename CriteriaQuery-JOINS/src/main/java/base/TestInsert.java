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

			Project p1=new Project("IT", "ONGOING");
			Project p2=new Project("MAT", "DONE");
			Project p3=new Project("XXX", "INVALID");

			Student s1=new Student("SAM", 111.1);s1.setProdObj(p1);

			Student s2=new Student("AAA", 22.2);s2.setProdObj(p1);

			Student s3=new Student("BBB", 33.3);

			Student s4=new Student("CCC", 44.4);s4.setProdObj(p2);

			Student s5=new Student("DDD", 55.5);s5.setProdObj(p2);

			p1.setStdObj(List.of(s1,s2));
			p2.setStdObj(List.of(s3,s5));

			ses.save(s1);
			ses.save(s2);
			ses.save(s3);
			ses.save(s4);
			ses.save(s5);

			ses.save(p3);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
