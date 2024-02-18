package edu.numetry.traineeship.task3.qrcodeclass;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import edu.numetry.traineeship.task3.Task3.StudentQRCode;

public class StudentQRCodeGenerator {

	public static void generateQRCode(StudentQRCode studentQRCode) throws WriterException, IOException {

		String qrCodePath = "D:\\Numetry\\D_T_Code";

		String qrCodeName = studentQRCode.getName() + "_" + studentQRCode.getQr_code_number() + "_QRCODE.png";

		QRCodeWriter qrCodeWriter = new QRCodeWriter();

		BitMatrix bitMatrix = qrCodeWriter.encode("QRCODENUMBER " + studentQRCode.getQr_code_number() + "\n" + "NAME "
				+ studentQRCode.getName() + "\n" + "EMAIL " + studentQRCode.getEmail() + "\n" + "CONTACT "
				+ studentQRCode.getContact() + "\n" + "LOCATION " + studentQRCode.getLocation(), BarcodeFormat.QR_CODE,
				400, 400);
		Path path = FileSystems.getDefault().getPath(qrCodeName);

		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

	}
}
