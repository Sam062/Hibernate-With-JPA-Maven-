package base.criteriaQuery;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

// SELECT * FROM EMPLOYEE-------------------
public class SelectAllFromEmployee {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			CriteriaBuilder builder=ses.getCriteriaBuilder();

			CriteriaQuery<Employee> query=builder.createQuery(Employee.class);

			Root<Employee> root=query.from(Employee.class);

			query.select(root);

			Query<Employee> q=ses.createQuery(query);

			List<Employee> list=q.list();

			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
