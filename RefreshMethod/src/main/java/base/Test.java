package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Employee emp=ses.get(Employee.class, 111);
			System.out.println(emp);
			
			ses.doWork(con->{
				con.createStatement().executeUpdate("update mergeorupdatetest set ename='QQQQQ'");
			});
			System.out.println("After Update");
			//without refresh if we get data then it will give older one 
			ses.refresh(emp);
			System.out.println(emp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
