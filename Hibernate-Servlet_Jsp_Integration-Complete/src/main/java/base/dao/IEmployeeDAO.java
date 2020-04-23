package base.dao;

import java.util.List;

import base.Employee;

public interface IEmployeeDAO {
	public Integer saveEmp(Employee e);

	public List<Employee> getAllEmp();
	
	public Employee getOneEmp(Integer id);

	public StringBuilder delEmp(Integer id);

	public StringBuilder updateEmp(Employee e);
}
