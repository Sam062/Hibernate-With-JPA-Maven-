package base.dao;

import java.util.List;

import base.Student;


public interface IStudentDAO {
	public Integer saveStudent(Student s);
	
	public List<Student> getAllStudents();

}
