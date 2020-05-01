package base.criteriaQuery;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;

import base.Employee;
import base.HibernateUtil;

//SELECT EID, ENAME FROM EMPLOYEE------------------------------
public class SelectMultiColumn {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			CriteriaBuilder builder=ses.getCriteriaBuilder();

			CriteriaQuery<Object[]> query=builder.createQuery(Object[].class);

			Root<Employee> root=query.from(Employee.class);

			//to Select Multiple Columns used multiselect()
			query.multiselect(root.get("eid"),root.get("ename"));

			Query<Object[]> q=ses.createQuery(query);
			List<Object[]> list=q.list();

			for (Object[] objects : list) {
				System.out.println(objects[0]+"-"+objects[1]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
