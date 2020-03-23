package base;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_InClause {

	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			
			//in clause works as OR Operator
			String hql="from base.Employee where eid in(:a)";
			Query<Employee> q=ses.createQuery(hql);
			
			q.setParameterList("a",new Object[] {101,103,104});
			//or
			//q.setParameterList("a", Arrays.asList(101,103,104));
			//or
			//q.setParameterList("a", List.of(101,103,104));
			
			List<Employee> l=q.list();
			l.forEach(System.out::println);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
