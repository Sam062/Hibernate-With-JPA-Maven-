package base.dao;

import java.util.List;

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
	@Override
	public List<EmployeeAdhar> getAllEmp() {
		String hql="FROM "+EmployeeAdhar.class.getName();
		List<EmployeeAdhar> list=null;
		Session ses=HibernateUtil.getSf().openSession();
		try(ses) {
			list =ses.createQuery(hql).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public StringBuilder delEmp(Integer id) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		StringBuilder s=new StringBuilder("");
		try(ses) {
			tx=ses.beginTransaction();
			EmployeeAdhar e=new EmployeeAdhar();
			e.setEmpID(id);

			ses.delete(e);

			tx.commit();
			s.append("Deleted Employee Detail");
		} catch (Exception e) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			s.append("Employee doesn't Exist!!");
			e.printStackTrace();
		}
		return s;
	}
	public EmployeeAdhar getOneEmp(Integer id) {
		Session ses=HibernateUtil.getSf().openSession();
		EmployeeAdhar ea=null;
		try(ses) {
			ea=ses.get(EmployeeAdhar.class,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ea;
	}
	public StringBuilder updateEmp(EmployeeAdhar e) {
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
		StringBuilder msg=null;
		try(ses) {
			tx=ses.beginTransaction();

			ses.update(e);

			tx.commit();
			msg=new StringBuilder("Employee Details Updated : ").append(e.getEmpID());
		} catch (Exception e2) {
			if(tx!=null && tx.getStatus().canRollback())
				tx.rollback();
			msg=new StringBuilder("Employee Doesn't Exist");
			e2.printStackTrace();
		}
		return msg;
	}
}
