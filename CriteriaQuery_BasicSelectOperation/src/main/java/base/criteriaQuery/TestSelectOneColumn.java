package base.criteriaQuery;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

//SELECT ENAME FROM EMPLOYEE
public class TestSelectOneColumn {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			//create CriteriaBuilder object thats used to construct full query
			CriteriaBuilder builder=ses.getCriteriaBuilder();

			//provide output type as CriteriaQuery<-> for select Operation
			CriteriaQuery<String> query=builder.createQuery(String.class);

			//specify table/model class name for "FROM section"
			Root<Employee> root=query.from(Employee.class);

			//provide Column details
			query.select(root.get("ename"));

			//Execution---------------------------
			Query<String> q=ses.createQuery(query);
			List<String> list=q.list();
			list.forEach(System.out::println);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
