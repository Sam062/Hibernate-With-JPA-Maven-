package base.update;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

//  UPDATE EMPLOYEE SET ENAME=?, ESAL=123.46 WHERE ENAME IS NULL;
public class TestUpdate {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaUpdate<Employee> criUpdate=builder.createCriteriaUpdate(Employee.class);

			Root<Employee> root=criUpdate.from(Employee.class);
			criUpdate.set("ename", "HAYHello");
			criUpdate.set("esal", 123.46);

			criUpdate.where(builder.isNull(root.get("ename")));

			Query  q=ses.createQuery(criUpdate);

			int count=q.executeUpdate();
			tx.commit();
			System.out.println("UPDATED------------------ROWS="+count);
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}
}
