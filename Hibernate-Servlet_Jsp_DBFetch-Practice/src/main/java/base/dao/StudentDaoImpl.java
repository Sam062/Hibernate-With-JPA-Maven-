package base.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import base.Student;
import base.util.HibernateUtil;

public class StudentDaoImpl implements IStudentDAO {
	@Override
	public Integer saveStudent(Student s) {
		Integer id=null;
		Session ses=HibernateUtil.getSf().openSession();
		Transaction tx=null;
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
	@Override
	public List<Student> getAllStudents() {
		List<Student> list=null;

		Session session=HibernateUtil.getSf().openSession();
		try {
			list=session.createQuery("FROM "+Student.class.getName())
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
