package in.shubhamjadhav.service;

import java.util.List;
import java.util.Optional;

import in.shubhamjadhav.models.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	Optional<Employee> getEmployeeById(long id);
	
	Employee updateEmployee(Employee employee, long id);
	
	void deleteEmployee(Long id);

}
