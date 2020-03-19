package base;


import org.hibernate.Session;

public class TestFetch {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			Employee emp=ses.get(Employee.class, 111);
			System.out.println(emp);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
