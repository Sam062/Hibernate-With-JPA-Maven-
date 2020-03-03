package base;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Module m=new Module(11,"m1");
			Module m1=new Module(12,"m2");
			Module m2=new Module(13,"m3");
			List<Module> l=Arrays.asList(m,m1,m2);
			
			Project p=new Project();
			p.setPid(50);
			p.setPname("NIT");
			p.setObs(l);
			
			ses.save(m);
			ses.save(m1);
			ses.save(m2);
			ses.save(p);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
