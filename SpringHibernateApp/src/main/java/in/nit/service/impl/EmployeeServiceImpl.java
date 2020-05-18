package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IEmployeeDao;
import in.nit.model.Employee;
import in.nit.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	@Autowired
	private IEmployeeDao dao;
	
	@Transactional
	public Integer saveEmployee(Employee emp) {
		//hra,ta..cal
		return dao.saveEmployee(emp);
	}

	@Transactional
	public void updateEmployee(Employee emp) {
		//hra,ta..cal
		dao.updateEmployee(emp);
	}

	@Transactional
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);
	}

	@Transactional(readOnly = true)
	public Employee getOneEmployee(Integer id) {
		return dao.getOneEmployee(id);
	}

	@Transactional(readOnly = true)
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
