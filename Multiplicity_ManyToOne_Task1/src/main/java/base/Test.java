package base;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Test {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			PublisherInfo pi=new PublisherInfo(101, "ORACLE", "Some Address");
			
			Book book=new Book();
			book.setBid(1);
			book.setBname("Who will cry");
			book.setPob(pi);
			
			Book book1=new Book();
			book1.setBid(2);
			book1.setBname("book 2");
			book1.setPob(pi);
			
			ses.save(pi);
			ses.save(book);
			ses.save(book1);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
