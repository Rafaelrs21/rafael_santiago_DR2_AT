package com.example.project_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class ProjectManagementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectManagementApplication.class, args);
	}
}
