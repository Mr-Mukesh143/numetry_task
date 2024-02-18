package edu.numetry.traineeship.task3.Task3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentQRCodeService {

	@Autowired
	private StudentQRCodeRepository studentQRCodeRepository;

	public StudentQRCode addStudentQRCode(StudentQRCode studentQRCode) {
		return studentQRCodeRepository.save(studentQRCode);
	}

	public StudentQRCode getStudentQRCode(int qr_code_number) {
		return studentQRCodeRepository.findById(qr_code_number).get();
	}

	public List<StudentQRCode> getStudentsQRCode() {
		return studentQRCodeRepository.findAll();
	}

	public StudentQRCode updateStudentQRCode(StudentQRCode studentQRCode, int qr_code_number) {
		StudentQRCode oldStudent = studentQRCodeRepository.findById(qr_code_number).get();
		oldStudent.setName(studentQRCode.getName());
		oldStudent.setEmail(studentQRCode.getEmail());
		oldStudent.setContact(studentQRCode.getContact());
		oldStudent.setLocation(studentQRCode.getLocation());
		return studentQRCodeRepository.save(oldStudent);
	}

	public void deleteStudentQRCode(int qr_code_number) {
		studentQRCodeRepository.deleteById(qr_code_number);
		System.out.println(qr_code_number + " removed");
	}

}
