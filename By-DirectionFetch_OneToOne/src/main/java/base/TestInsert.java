package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Employee emp=new Employee();
			emp.setEid(101);
			emp.setEname("XXX");
			emp.setEsal(123.4);
			
			Profile pro=new Profile();
			pro.setPid(101);
			pro.setPname("A");
			pro.setEmpObj(emp);
			
			emp.setProfObj(pro);
			
			ses.save(emp);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
