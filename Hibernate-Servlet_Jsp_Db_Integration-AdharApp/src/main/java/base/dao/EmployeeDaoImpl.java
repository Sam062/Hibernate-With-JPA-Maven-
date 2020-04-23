package base.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.EmployeeAdhar;
import base.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDAO {
	@Override
	public Integer insertEmp(EmployeeAdhar emp) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Integer id=null;
		try(ses) {
			tx=ses.beginTransaction();
			
			id=(Integer)ses.save(emp);
			
			tx.commit();
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			e.printStackTrace();
		}
		return id;
	}
}
