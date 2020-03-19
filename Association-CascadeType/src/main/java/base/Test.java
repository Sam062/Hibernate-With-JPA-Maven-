package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Address a1=new Address(101, "HYD");
			Address a2=new Address(102, "LKO");
			Address a3=new Address(103, "MUM");
			
			List<Address> addrs=List.of(a1,a2,a3);
			
			Employee emp=new Employee();
			emp.setEid(111);
			emp.setEname("NEW");
			emp.setEsal(123.4);
			emp.setAddr(addrs);
			
			ses.save(emp);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
