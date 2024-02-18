package edu.numetry.traineeship.task3.Task3;

import java.io.IOException;
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

import com.google.zxing.WriterException;

import edu.numetry.traineeship.task3.qrcodeclass.StudentQRCodeGenerator;

@RestController
@RequestMapping("/studentqrcode")
public class StudentQRCodeController {

	@Autowired
	private StudentQRCodeService studentQRCodeService;

	@PostMapping("/addStudentQRCode")
	public StudentQRCode addStudentQRCode(@RequestBody StudentQRCode studentQrCode) {
		return studentQRCodeService.addStudentQRCode(studentQrCode);
	}

	@GetMapping("/getStudentsQRCode")
	public List<StudentQRCode> getStudentsQRCode() throws WriterException, IOException {
		List<StudentQRCode> studentQRCodes = studentQRCodeService.getStudentsQRCode();
		if (studentQRCodes.size() != 0) {
			for (StudentQRCode studentQRCode : studentQRCodes) {
				StudentQRCodeGenerator.generateQRCode(studentQRCode);
			}
		}
		return studentQRCodeService.getStudentsQRCode();
	}

	@GetMapping("/getStudentQRCode/{qr_code_number}")
	public StudentQRCode getStudentQRCode(@PathVariable int qr_code_number) throws WriterException, IOException {
		StudentQRCode studentQRCod = studentQRCodeService.getStudentQRCode(qr_code_number);
		StudentQRCodeGenerator.generateQRCode(studentQRCod);

		return studentQRCodeService.getStudentQRCode(qr_code_number);
	}

	@PutMapping("/updateStudentQRCode/{qr_code_number}")
	public StudentQRCode updateStudentQRCode(@RequestBody StudentQRCode studentQrCode,
			@PathVariable("qr_code_number") int qr_code_number) {

		return studentQRCodeService.updateStudentQRCode(studentQrCode, qr_code_number);
	}

	@DeleteMapping("/deleteStudentQRCode/{qr_code_number}")
	public void deleteStudentQRCode(@PathVariable int qr_code_number) {
		studentQRCodeService.deleteStudentQRCode(qr_code_number);
	}

}
