package base;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			//update base.Employee set ename=:ENAME,esal=:ESAL where eid=:EID;
			String hql=new StringBuilder("Update ")
					.append(Employee.class.getName())
					.append(" set ename=:ENAME, esal=:ESAL")
					.append(" where eid=:EID")
					.toString();
			System.out.println(hql);
			Query<Employee> q=ses.createQuery(hql);
			q.setParameter("ENAME", "XXXXX");
			q.setParameter("ESAL", 999.99);
			q.setParameter("EID", 105);
			
			int count=q.executeUpdate();
			System.out.println("----DONE-----");
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback()) {
				tx.rollback();
			}
			e.printStackTrace();
		}
	}

}
