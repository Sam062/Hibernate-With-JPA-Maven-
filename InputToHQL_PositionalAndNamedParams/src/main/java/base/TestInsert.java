package base;


import org.hibernate.Session;
import org.hibernate.Transaction;
public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Employee e1=new Employee(101, "A", 123.4);
			Employee e2=new Employee(102, "B", 223.4);
			Employee e3=new Employee(103, "C", 323.4);
			
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
