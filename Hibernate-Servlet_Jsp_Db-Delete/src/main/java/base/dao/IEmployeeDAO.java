package base.dao;

import java.util.List;

import base.Employee;

public interface IEmployeeDAO {
	public Integer insertEmp(Employee e);
	
	public List<Employee> getAllEmp();
	
	public String delEmp(Integer id);

}
