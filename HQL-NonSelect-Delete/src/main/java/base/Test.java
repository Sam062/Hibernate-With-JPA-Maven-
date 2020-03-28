package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			//DELETE FROM base.Employee WHERE EID=:EID;
			String hql=new StringBuilder("DELETE FROM ")
					.append(Employee.class.getName())
					.append(" WHERE EID=:EID")
					.toString();
			System.out.println(hql);
			
			int count=ses.createQuery(hql)
					.setParameter("EID", 104)
					.executeUpdate();
			
			System.out.println("----DELETED-----");
			
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null&& tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

}
