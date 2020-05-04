package base;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class TestJoin {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaQuery<Object[]> query=builder.createQuery(Object[].class);

			Root<Student> root=query.from(Student.class);

			Join<Object, Object> prj=root.join("prObj",JoinType.INNER);
			query.multiselect(
					root.get("sid"),
					root.get("sname"),
					prj.get("pcode"),
					prj.get("pinfo"),
					prj.get("pid")
					);
			Query<Object[]> q=ses.createQuery(query);
			List<Object[]> ob=q.list();
			for (Object[] o : ob) {
				System.out.println(o[0]+"-"+o[1]+"-"+o[2]+"-"+o[3]+"-"+o[4]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
