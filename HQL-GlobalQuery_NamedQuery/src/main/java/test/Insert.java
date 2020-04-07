package test;


import org.hibernate.Session;
import org.hibernate.Transaction;

import base.Employee;
import base.HibernateUtil;

public class Insert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();

			Employee emp=new Employee(101,"A",123.1);
			Employee emp1=new Employee(102,"B",123.2);
			Employee emp2=new Employee(103,"C",123.3);
			Employee emp3=new Employee(104,"D",123.4);
			Employee emp4=new Employee(105,"E",123.5);
			Employee emp5=new Employee(106,"F",123.6);
			
			ses.save(emp);
			ses.save(emp1);
			ses.save(emp2);
			ses.save(emp3);
			ses.save(emp4);
			ses.save(emp5);
			
			System.out.println("DONE");
			
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
