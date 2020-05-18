package in.nit.service;

import java.util.List;

import in.nit.model.Employee;

public interface IEmployeeService {
	
	public  Integer saveEmployee(Employee emp);
	public  void updateEmployee(Employee emp);
	public  void deleteEmployee(Integer id);

	public  Employee getOneEmployee(Integer id);
	public List<Employee> getAllEmployees();
}
