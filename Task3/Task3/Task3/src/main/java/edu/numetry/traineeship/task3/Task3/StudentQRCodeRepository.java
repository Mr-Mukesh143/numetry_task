package edu.numetry.traineeship.task3.Task3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentQRCodeRepository extends JpaRepository<StudentQRCode, Integer>{

	List<StudentQRCode> findByName(String name);
	
}
