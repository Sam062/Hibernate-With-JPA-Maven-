package base;

import org.hibernate.Session;

public class TestFetch {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		
		try(ses) {
			Employee emp=ses.get(Employee.class, 101);
			System.out.println(emp);
			
			Profile pro=ses.get(Profile.class, 101);
			System.out.println(pro.getPid()+"--"+pro.getPname());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
