package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			PanCard pob=new PanCard(12345, "98ORF45L", "SHIVAM MISHRA");
			PanCard pob1=new PanCard(23456, "89SSD45R", "Adarsh Pratap");
			
			Employee emp=new Employee();
			emp.setEmpId(101);
			emp.setEmmName("Adarsh");
			emp.setEmpSal(500.5);
			emp.setPan(pob1);

			Employee emp1=new Employee();
			emp1.setEmpId(102);
			emp1.setEmmName("Shivam");
			emp1.setEmpSal(254.55);
			emp1.setPan(pob);
			
			ses.save(pob);
			ses.save(pob1);
			
			ses.save(emp1);
			ses.save(emp);
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
