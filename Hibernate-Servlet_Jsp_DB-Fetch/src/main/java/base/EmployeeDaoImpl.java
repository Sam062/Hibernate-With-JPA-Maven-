package base;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements IEmployeeDao {

	@Override
	public Integer saveEmp(Employee e) {
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

			Query<Employee> q=ses.createQuery(hql);
			list=q.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}
