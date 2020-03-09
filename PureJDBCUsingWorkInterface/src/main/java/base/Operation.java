package base;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.jdbc.Work;

public class Operation {
	public static void main(String[] args) {
		
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		
		try(ses) {
			tx=ses.beginTransaction();
			ses.doWork(new Work() {
				@Override
				public void execute(Connection connection) throws SQLException {
					String sql="insert into demo values(10,'A',12.55)";
					Statement st=connection.createStatement();
					int count=st.executeUpdate(sql);
					System.out.println("done "+count);
				}
			});
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

}
