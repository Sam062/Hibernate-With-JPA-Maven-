package base.test;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

public class UpdateTest {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaUpdate<Employee> update=builder.createCriteriaUpdate(Employee.class);

			Root<Employee> root=update.from(Employee.class);
			update.set(root.get("ename"),"LLLPPP");
			update.set(root.get("esal"),98765.5);

			update.where(builder.equal(root.get("eid"),101));

			Query<Employee> q=ses.createQuery(update);
			Integer count=q.executeUpdate();
			tx.commit();
			System.out.println("--------------------------UPDATED ROWS ="+count);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
