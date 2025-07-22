package in.shubhamjadhav.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.shubhamjadhav.models.Employee;
import in.shubhamjadhav.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")  // or "/"
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/getEmployeeById/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/updateEmployee/{id}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable long id) {
		Employee existingEmployee = employeeService.getEmployeeById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		return employeeService.saveEmployee(existingEmployee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}

}
