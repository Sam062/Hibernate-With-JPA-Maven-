package base.testSelect;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

public class SelectMultiCol {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {

			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaQuery<Object[]> query=builder.createQuery(Object[].class);

			Root<Employee> root=query.from(Employee.class);
			query.multiselect(root.get("ename"),root.get("esal"));

			Query<Object[]> q=ses.createQuery(query);
			List<Object[]> list=q.list();

			for (Object[] ob : list) {
				System.out.println(ob[0]+"-"+ob[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
