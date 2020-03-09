package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.ReturningWork;

public class Operation {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		
		
		try(ses) {
			tx=ses.beginTransaction();
			int count=ses.doReturningWork(new ReturningWork<Integer>() {
				@Override
				public Integer execute(Connection connection) throws SQLException {
					int count=0;
					String sql="insert into demo values(111,'XXX',999.7)";
					Statement st=connection.createStatement();
					count=st.executeUpdate(sql);
					
					return count;
				}
			});
			
			System.out.println("DONE "+count);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
