package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses1=HibernateUtil.getSf().openSession();
//		Session ses2=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Transaction tx1=null;
		try(ses1) {
			/*  To Insert in DB
			 * 
			 * tx=ses1.beginTransaction(); Employee emp=new Employee(); emp.setEid(111);
			 * emp.setEname("ABC"); emp.setEsal(123.4); ses1.save(emp);
			 */
			
			
			
			tx=ses1.beginTransaction();
			Employee e1=ses1.get(Employee.class, 111);
			System.out.println("emp1"+e1);
			e1.setEname("SAM");
			System.out.println("name changed emp in Cache :"+ses1.contains(e1));
			ses1.update(e1); 
//			tx.commit();
			System.out.println("updated emp1"+e1);//Employee(eid=111, ename=SAM, esal=123.4)
			
			System.out.println("Second Updation");
			Employee e2=ses1.get(Employee.class, 111);
			System.out.println(e2);
			e2.setEname("UpdatedSAM");
			ses1.update(e2);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
