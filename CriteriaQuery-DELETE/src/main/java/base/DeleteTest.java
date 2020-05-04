package base;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DeleteTest {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaDelete<Employee> delete=builder.createCriteriaDelete(Employee.class);

			Root<Employee> root=delete.from(Employee.class);
			//DELETE FROM EMPLOYEE WHERE ENAME LIKE ? , EID > ?;
			delete.where(builder.or(
					builder.like(root.get("ename"),"L%"),
					builder.greaterThan(root.get("eid"), 100)
					));

			Query<Employee> q=ses.createQuery(delete);
			int count=q.executeUpdate();
			tx.commit();
			System.out.println("-----------------DELETED ROWS="+count);
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}
}
