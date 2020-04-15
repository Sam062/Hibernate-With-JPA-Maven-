package base.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.Employee;
import base.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDao{
	@Override
	public Integer saveStudent(Employee s) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Integer id=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			id=(Integer)ses.save(s);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return id;
	}

}
