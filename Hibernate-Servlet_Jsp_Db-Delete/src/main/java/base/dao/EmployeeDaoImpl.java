package base.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import base.Employee;
import base.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDAO{
	@Override
	public Integer insertEmp(Employee e) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		Integer id=null;
		try(ses) {
			tx=ses.beginTransaction();

			id=(Integer)ses.save(e);

			tx.commit();
		} catch (Exception e2) {
			tx.rollback();
			e2.printStackTrace();
		}
		return id;
	}
	@Override
	public List<Employee> getAllEmp() {
		Session ses=HibernateUtil.getSf().openSession();
		List<Employee> list=null;
		try(ses) {
			String hql="FROM "+Employee.class.getName();
			list=ses.createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String delEmp(Integer id) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		String out=null;
		try(ses) {
			tx=ses.beginTransaction();

			Employee e=new Employee();
			e.setEid(id);

			ses.delete(e);

			tx.commit();
			out="Employee "+id+" deleted !!";
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return out;
	}
}
