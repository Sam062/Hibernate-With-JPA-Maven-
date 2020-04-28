package base.dao;

import java.util.List;

import base.EmployeeAdhar;

public interface IEmployeeDAO {
	public Integer insertEmp(EmployeeAdhar emp);
	
	public List<EmployeeAdhar> getAllEmp();
	
	public StringBuilder delEmp(Integer id);
	
	public EmployeeAdhar getOneEmp(Integer id);
}
