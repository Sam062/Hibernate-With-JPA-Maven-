package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test_GoodPerformance {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			String hql=new StringBuilder("Update ")
					.append(Employee.class.getName())
					.append(" set ename=:ENAME, esal=:ESAL")
					.append(" where eid=:EID")
					.toString();
			System.out.println(hql);

			int count=ses.createQuery(hql)
					.setParameter("ENAME", "ZZZZZZ")
					.setParameter("ESAL", 555.555)
					.setParameter("EID", 104)
					.executeUpdate();
			
			System.out.println("----DONE----");

			tx.commit();
		} catch (Exception e) {
			if(tx !=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

}
