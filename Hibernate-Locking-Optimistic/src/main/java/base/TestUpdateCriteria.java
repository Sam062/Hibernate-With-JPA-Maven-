package base;

import java.util.concurrent.TimeUnit;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class TestUpdateCriteria {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try (ses){
			tx=ses.beginTransaction();

			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaUpdate<Student> query=builder.createCriteriaUpdate(Student.class);

			Root<Student> root=query.from(Student.class);
			query.set("sname", "SSSS");
			query.set("sfee", 999.19);
			query.set("vrsn", 2);
			query.where(builder.isNull(root.get("sname")));

			Query<Student> q=ses.createQuery(query);
			Thread.sleep(TimeUnit.SECONDS.toMillis(30));
			System.out.println("******  SLEEPING *****");
			int count=q.executeUpdate();

			System.out.println("============DONE-----------"+count);


			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
