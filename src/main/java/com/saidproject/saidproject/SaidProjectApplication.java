package com.saidproject.saidproject;

import com.saidproject.saidproject.repo.MainImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SaidProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaidProjectApplication.class, args);
		MainImpl mainImpl = new MainImpl();
	}

}
