package in.shubhamjadhav.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.shubhamjadhav.models.Employee;
import in.shubhamjadhav.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	// Constructor Injection (preferred)
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		return employeeRepository.save(existingEmployee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee existingEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		
		employeeRepository.delete(existingEmployee);
	}
}
