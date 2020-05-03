package base.testSelect;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

public class SelectOneCol {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {

			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaQuery<String> query=builder.createQuery(String.class);

			Root<Employee> root=query.from(Employee.class);
			query.select(root.get("ename"));

			Query<String> q=ses.createQuery(query);
			List<String> list=q.list();

			list.forEach(System.out::println);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
