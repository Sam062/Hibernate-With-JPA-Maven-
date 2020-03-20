package base;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_PositionalParam {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Scanner sc=new Scanner(System.in);
		try(ses;sc) {
			System.out.println("Input employee id");
			int eid=sc.nextInt();

			String hql="from base.Employee where eid>=?0";
			Query q=ses.createQuery(hql);
			q.setParameter(0, eid);
			
			List<Employee> list=q.list();
			list.forEach(System.out::println);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
