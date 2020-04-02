package test;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.HibernateUtil;
import base.Model;
import base.Product;

public class TestInsert {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			Model m1=new Model(55,"RED");
			Model m2=new Model(56,"BLUE");
			Model m3=new Model(57,"PINK");
			Model m4=new Model(58,"CYAN");
			Model m5=new Model(59,"GRAY");
			
			Product p1=new Product(10,"A",3.2,null);
			Product p2=new Product(11,"B",4.2,Arrays.asList(m2));
			Product p3=new Product(12,"C",5.2,null);
			Product p4=new Product(13,"D",6.2,Arrays.asList(m4));
			Product p5=new Product(14,"E",7.2,null);
			
			ses.save(p1);
			ses.save(p2);
			ses.save(p3);
			ses.save(p4);
			ses.save(p5);
			
			ses.save(m1);
			ses.save(m2);
			ses.save(m3);
			ses.save(m4);
			ses.save(m5);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
	}

}
