package com.task1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@PostMapping("/addStudents")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studentService.addStudents(students);
	}

	@GetMapping("/getStudents")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/getStudentById/{id}")
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudentById(id);
	}

	@GetMapping("/getStudentByName/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}

	@PutMapping("/updateStudent/{id}")
	public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {

		return studentService.updateStudent(student, id);
	}

	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteStudent(id);
	}

}
