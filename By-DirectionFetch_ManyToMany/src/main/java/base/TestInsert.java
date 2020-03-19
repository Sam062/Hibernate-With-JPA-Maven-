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
			
			
			Course c1=new Course();
			c1.setCid(111);
			c1.setCode("HIB");
			
			Course c2=new Course();
			c2.setCid(222);
			c2.setCode("SPR");
			
			Course c3=new Course();
			c3.setCid(333);
			c3.setCode("BOOt");
			
			List<Course> l1=List.of(c1,c2);
			List<Course> l2=List.of(c2,c3);
			
			Student std=new Student();
			std.setSid(101);
			std.setSname("ABC");
			std.setSfee(123.4);
			std.setCrsObj(l1);
			
			Student s2=new Student();
			s2.setSid(102);
			s2.setSname("XXX");
			s2.setSfee(133.5);
			s2.setCrsObj(l2);

			Student s3=new Student();
			s3.setSid(103);
			s3.setSname("ZZZ");
			s3.setSfee(135.9);
			s3.setCrsObj(l2);
			
			ses.save(std);
			ses.save(s2);
			ses.save(s3);
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
