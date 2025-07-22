package in.shubhamjadhav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.shubhamjadhav.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
