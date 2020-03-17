package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class MainTest {
	public static void main(String[] args) {
		Session ses1 = HibernateUtil.getSf().openSession();
		Session ses2 = HibernateUtil.getSf().openSession();
		Transaction tx = ses1.beginTransaction();
		try (ses1) {

			Employee e1 = ses1.get(Employee.class, 111);
			e1.setEname("XXX");
			System.out.println("renamed :" + e1);
			ses1.update(e1);
			tx.commit();
			System.out.println("first update done");


			/*
			 * Employee e2 = ses1.get(Employee.class, 111); e1.setEname("ZZZ");
			 * System.out.println("renamed :" + e1); ses1.update(e2); tx.commit();
			 * ses1.close(); System.out.println("2nd update done");
			 */

			//Using e1 in other session here same PK value can't get updated saying NonUniqueObjectException so used merge()
			System.out.println(ses1.contains(e1)); 
			System.out.println("2nd Update");
			tx=ses2.beginTransaction(); 
			Employee e2=ses2.get(Employee.class, 111);
			System.out.println(ses2.contains(e2)); 
			ses2.update(e1); 
			//ses2.merge(e1);
			tx.commit();


		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
