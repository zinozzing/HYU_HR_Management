package com.hyhr.hr_proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class HrProjApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(HrProjApplication.class);
		application.addListeners(new ApplicationPidFileWriter());
		application.run(args);
	}

}