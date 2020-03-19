package base;

import java.util.List;

import org.hibernate.Session;

public class TestFetch {
	public static void main(String[] args) {
		Session ses=HibernateUtil.getSf().openSession();
		
		try(ses) {
			
			Student std=ses.get(Student.class, 101);
			System.out.println(std);
			
			Course crs=ses.get(Course.class, 222);
			System.out.println(crs);
			List<Student> st=crs.getStdObj();
			st.forEach(System.out::println);
			//System.out.println(crs.getCid()+"--"+crs.getCode()+"--"+st.get(0));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
