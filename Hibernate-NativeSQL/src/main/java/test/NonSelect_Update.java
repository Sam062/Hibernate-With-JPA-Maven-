package test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import base.HibernateUtil;

public class NonSelect_Update {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			String sql="UPDATE EMPLOYEE SET ENAME=:A, ESAL=:B WHERE EID=:C";
			NativeQuery nq=ses.createSQLQuery(sql);
			nq.setParameter("A", "SAM");
			nq.setParameter("B", 999.9);
			nq.setParameter("C", 101);
			
			int count=nq.executeUpdate();
			System.out.println(count);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
