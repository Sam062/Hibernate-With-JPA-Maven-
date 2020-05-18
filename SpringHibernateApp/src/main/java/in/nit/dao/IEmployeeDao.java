package in.nit.dao;

import java.util.List;

import in.nit.model.Employee;

public interface IEmployeeDao {

	public  Integer saveEmployee(Employee emp);
	public  void updateEmployee(Employee emp);
	public  void deleteEmployee(Integer id);
	
	public  Employee getOneEmployee(Integer id);
	public List<Employee> getAllEmployees();
}
