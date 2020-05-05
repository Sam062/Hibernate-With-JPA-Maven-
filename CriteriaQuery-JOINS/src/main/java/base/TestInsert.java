package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Project p1=new Project("IT","ONGOING");
			Project p2=new Project("MAT","DONE");
			Project p3=new Project("IV","INVALID");

			Student s1=new Student(null,"SAM", 111.1, p1);
			Student s2=new Student(null,"AAA", 222.2, p1);
			Student s3=new Student(null,"WASTE", 333.3, null);
			Student s4=new Student(null,"BBB", 44.4, p2);
			Student s5=new Student(null,"CCC", 555.5, p2);

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
