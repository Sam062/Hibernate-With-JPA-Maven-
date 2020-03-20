package base;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Test_UniqueResultMethod {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Scanner sc=new Scanner(System.in);
		try(ses;sc) {
			System.out.println("Input employee id");
			int eid=sc.nextInt();

			String hql="from base.Employee where eid=?0";
			Query q=ses.createQuery(hql);
			q.setParameter(0, eid);

			Object ob=q.uniqueResult();
			Employee e=(Employee)ob;
			System.out.println(e.getEmpName());
			System.out.println(e.getEmpSal());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
