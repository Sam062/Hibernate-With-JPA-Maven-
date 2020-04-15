package base.dao;

import base.Employee;

public interface IEmployeeDao {
	/**
	 * This Method takes model class object as input
	 * and returns PrimaryKey(Integer as)Output
	 * 
	 */
	public Integer saveStudent(Employee s);
}
