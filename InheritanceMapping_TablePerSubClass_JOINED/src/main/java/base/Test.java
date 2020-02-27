package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HiberbateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Person pobj=new Person();
			pobj.setPerId(10);
			pobj.setPerName("A");
			
			Employee emp=new Employee();
			emp.setPerId(11);
			emp.setPerName("B");
			emp.setEmpSal(1.2);
			emp.setEmpDept("DEV");
			
			Student st=new Student();
			st.setPerId(12);
			st.setPerName("C");
			st.setStdFee(2.2);
			st.setStdGrd("O");
			
			ses.save(pobj);
			ses.save(emp);
			ses.save(st);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
