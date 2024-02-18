package com.task1;

import java.util.List;

public interface StudentService {

	Student addStudent(Student student);
	List<Student> addStudents(List<Student> students);
	List<Student> getStudents();
	Student getStudentById(int id);
	List<Student> getStudentByName(String name);
	Student updateStudent(Student student, int id);
	void deleteStudent(int id);

}
