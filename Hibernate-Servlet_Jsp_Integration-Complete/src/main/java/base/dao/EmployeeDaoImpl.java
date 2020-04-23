package base.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import base.Employee;
import base.util.HibernateUtil;

public class EmployeeDaoImpl implements IEmployeeDAO {

	@Override
	public Integer saveEmp(Employee emp) {
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

	@Override
	public List<Employee> getAllEmp() {
		Session ses=HibernateUtil.getSf().openSession();
		List<Employee> list=null;
		try(ses) {
			list=ses.createQuery("FROM "+Employee.class.getName()).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Employee getOneEmp(Integer id) {
		Employee emp=null;
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			emp=ses.get(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
	@Override
	public StringBuilder delEmp(Integer id) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		StringBuilder msg=new StringBuilder("Employee ");
		try(ses) {
			tx=ses.beginTransaction();

			Employee e=new Employee();
			e.setEid(id);

			ses.delete(e);

			tx.commit();
			msg.append(id).append(" Details Deleted.");
		} catch (Exception e1) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			msg.append(id).append(" DETAILS NOT FOUND.");
			e1.printStackTrace();
		}
		return msg;
	}
	@Override
	public StringBuilder updateEmp(Employee e) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		StringBuilder msg=new StringBuilder("EMPLOYEE ");
		try(ses) {
			tx=ses.beginTransaction();

			ses.update(e);

			tx.commit();
			msg.append(e.getEname()).append(" Updated.");
		} catch (Exception e2) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			msg.append(e.getEname()).append(" Details not Found.");
			e2.printStackTrace();
		}
		return msg;
	}
}
