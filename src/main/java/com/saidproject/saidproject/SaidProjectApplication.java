package com.saidproject.saidproject;

import com.saidproject.saidproject.repo.MainImpl;
import com.saidproject.saidproject.utils.GenerateWordFile;
import com.saidproject.saidproject.utils.GenerateWordFileImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaidProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaidProjectApplication.class, args);
		GenerateWordFile generateWordFile = new GenerateWordFileImp();
		generateWordFile.convert();
	}

}
