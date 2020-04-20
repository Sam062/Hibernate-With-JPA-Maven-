package base;

import java.util.List;

public interface IEmployeeDao {
	
	/**
	 * This Method takes model class object as input
	 * and returns PrimaryKey(Integer as)Output
	 */
	public Integer saveEmp(Employee e);

	public List<Employee> getAllEmp();

}
