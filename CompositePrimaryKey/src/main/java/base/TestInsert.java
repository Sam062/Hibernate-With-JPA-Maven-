package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			EmpIdType eid=new EmpIdType();
			eid.setDeptId(555);
			eid.setEmpId(101);
			
			Employee e=new Employee();
			e.setEid(eid);
			e.setEmpName("SAM");
			e.setEmpSal(15.25);
			
			ses.save(e);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
