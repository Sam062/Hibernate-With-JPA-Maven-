package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test2 {

	public static void main(String[] args) {
		Session ses1 = HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try (ses1) {
			tx=ses1.beginTransaction();
			Employee e1=ses1.get(Employee.class , 1234);
			e1.setEname("Checking");

			ses1.update(e1);
			tx.commit();



		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}


