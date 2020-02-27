package base;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {

		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Date d=new Date(System.currentTimeMillis());

			EmployeeContract ecobj=new EmployeeContract();
			ecobj.setStartDate(d);
			ecobj.setEndDate(d);

			Employee eobj=new Employee();
			eobj.setEid(101);
			eobj.setEname("SAM");
			eobj.setEc(ecobj);

			ses.save(eobj);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
