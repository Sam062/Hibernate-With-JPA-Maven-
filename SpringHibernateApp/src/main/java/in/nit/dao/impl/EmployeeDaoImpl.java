package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IEmployeeDao;
import in.nit.model.Employee;

@Repository //=create obj + Db Operations
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveEmployee(Employee emp) {
		return (Integer) ht.save(emp);
	}

	@Override
	public void updateEmployee(Employee emp) {
		ht.update(emp);
	}

	@Override
	public void deleteEmployee(Integer id) {
		ht.delete(new Employee(id));
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return ht.get(Employee.class, id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return ht.loadAll(Employee.class);
	}

}
