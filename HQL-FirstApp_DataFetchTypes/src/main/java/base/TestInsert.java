package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Employee e1=new Employee(111, "A", 1.1);
			Employee e2=new Employee(222, "B", 2.1);
			Employee e3=new Employee(333, "C", 3.1);
			
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
