package in.shubhamjadhav.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.shubhamjadhav.beans.Student;

@RestController
public class StudentController {

	public static List<Student> students = new ArrayList<Student>();
	
	
	
	public StudentController() {
		students.add(new Student("shubham","Jadhav"));
		students.add(new Student("Rushi","Solanke"));
		students.add(new Student("Arjun","Mule"));
		students.add(new Student("Dhanno","J"));
		
	}



	@GetMapping("students")
	public List<Student> getStudents(){
		return students;
	}
	
	@GetMapping("/student/{firstName}/{lastName}")
	public Student studentPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName )
	{
		return new Student(firstName, lastName);
	}
	
	@GetMapping("/student/query")
	public Student studentQueryParameter(@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName)
	{
		return new Student(firstName,lastName);
	}
	
	@PostMapping("/student")
	public void addStudent(@RequestBody Student student)
	{
		students.add(student);
	}
	
	
	@PutMapping("/student/{firstName}")
	public void updateStudent(@PathVariable("firstName") String firstName, @RequestBody Student student )
	{
		for(Student x : students ) {
			if (x.getFirstName().equals(firstName)) {
				x.setFirstName(student.getFirstName());
				x.setLastName(student.getLastName());
			}
		}
	}
	
	
	@DeleteMapping("/student/{firstName}")
	public void deleteStudent(@PathVariable("firstName") String firstName) {
		for(Student x : students) {
			if (x.getFirstName().equals(firstName)) {
				students.remove(x);
			}
		}
	}
	
}
