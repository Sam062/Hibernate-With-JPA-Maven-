package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test_InOperator {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			String hql=new StringBuilder("DELETE FROM ")
					.append(Employee.class.getName())
					.append(" WHERE EID IN (:A)")
					.toString();
			System.out.println(hql);
			
			int count=ses.createQuery(hql)
					.setParameter("A", List.of(101,103,105))
					.executeUpdate();
			System.out.println("-----DELETED-----");
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

}
