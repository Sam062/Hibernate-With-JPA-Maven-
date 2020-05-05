package base;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class TestJOIN {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaQuery<Object[]> query=builder.createQuery(Object[].class);

			Root<Student> root=query.from(Student.class);

			Join<Object, Object> prj=root.join("prjs",JoinType.LEFT);
			query.multiselect(
					root.get("sid"),
					root.get("sname"),
					prj.get("pname"),
					prj.get("pinfo"),
					prj.get("pid")
					);
			Query<Object[]> q=ses.createQuery(query);
			List<Object[]> l=q.list();
			for (Object[] ob : l) {
				System.out.println(ob[0]+"-"+ob[1]+"-"+ob[2]+"-"+ob[3]+"-"+ob[4]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
