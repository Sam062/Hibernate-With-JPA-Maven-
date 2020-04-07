package test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import base.Employee;
import base.HibernateUtil;

public class FetchMultiCols {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			String sql="SELECT ENAME,ESAL FROM EMPLOYEE";
			
			NativeQuery nq=ses.createSQLQuery(sql);
			List<Object[]> l=nq.list();

			for (Object[] objects : l) {
				System.out.println(objects[0]+"--"+objects[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
