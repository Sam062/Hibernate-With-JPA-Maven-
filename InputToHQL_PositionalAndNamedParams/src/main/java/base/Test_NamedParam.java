package base;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_NamedParam {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Scanner sc=new Scanner(System.in);
		try(ses;sc) {
			System.out.println("Input employee id");
			int empId=sc.nextInt();

			String hql="from base.Employee where eid>=:eid";
			Query q=ses.createQuery(hql);
			q.setParameter("eid", empId);

			List<Employee> list=q.list();
			list.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
