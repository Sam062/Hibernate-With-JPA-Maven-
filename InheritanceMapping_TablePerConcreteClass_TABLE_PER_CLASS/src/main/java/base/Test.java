package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Person p=new Person();
			p.setPerId(10);
			p.setPerName("A");
			
			Employee e=new Employee();
			e.setPerId(11);
			e.setPerName("B");
			e.setEmpSal(1.2);
			e.setEmpDept("DEV");
			
			Student s=new Student();
			s.setPerId(12);
			s.setPerName("C");
			s.setStdFee(2.2);
			s.setStdGrd("O");
			
			ses.save(p);
			ses.save(e);
			ses.save(s);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
