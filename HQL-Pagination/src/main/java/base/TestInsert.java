package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			
			Employee e=new Employee(100,null,123.0); //Null not accepted here if in model class nullable=false
			Employee e1=new Employee(101,"B",123.1);
			Employee e2=new Employee(102,"C",123.2);
			Employee e3=new Employee(103,"D",123.3);
			Employee e4=new Employee(104,"E",123.4);
			Employee e5=new Employee(105,"F",123.5);
			
			ses.save(e);
			ses.save(e1);
			ses.save(e2);
			ses.save(e3);
			ses.save(e4);
			ses.save(e5);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

}
