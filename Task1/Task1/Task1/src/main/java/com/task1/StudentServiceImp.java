 package com.task1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> addStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	@Override
	public Student getStudentById(int id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public List<Student> getStudentByName(String name) {
		return studentRepository.findByName(name);
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, int id) {
		Student oldStudent = studentRepository.findById(id).get();
		oldStudent.setName(student.getName());
		oldStudent.setAge(student.getAge());
		oldStudent.setEmail(student.getEmail());
		oldStudent.setContact(student.getContact());
		oldStudent.setCity(student.getCity());
		oldStudent.setPincode(student.getPincode());
		return studentRepository.save(oldStudent);
	}

	@Override
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
		System.out.println(id + " removed");
	}

}
