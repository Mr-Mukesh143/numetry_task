package edu.numetry.traineeship.task3.Task3;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentQRCode {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qr_code_number;
	private String name;
	private String email;
	private long contact;
	private String location;

	public int getQr_code_number() {
		return qr_code_number;
	}

	public void setQr_code_number(int qr_code_number) {
		this.qr_code_number = qr_code_number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public StudentQRCode(int qr_code_number, String name, String email, long contact, String location) {
		super();
		this.qr_code_number = qr_code_number;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.location = location;
	}

	public StudentQRCode() {
		super();
	}
}
