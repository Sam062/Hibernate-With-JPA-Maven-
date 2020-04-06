package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestFetch {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			EmpIdType eid=new EmpIdType();
			eid.setDeptId(555);
			eid.setEmpId(101);
			
			Employee e=ses.get(Employee.class, eid);
			System.out.println(e);

			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
