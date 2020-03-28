package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test_BetweenOperator {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			String hql=new StringBuilder("DELETE FROM ")
					.append(Employee.class.getName())
					.append(" WHERE EID BETWEEN :a AND :b")
					.toString();
			
			int count=ses.createQuery(hql)
					.setParameter("a", 101)
					.setParameter("b", 103)
					.executeUpdate();
			System.out.println("---DELETED---");
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

}
