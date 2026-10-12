package com.example.bean_lifecycle;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeanLifecycleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeanLifecycleApplication.class, args);
	}

	@Bean(initMethod = "customInit", destroyMethod = "customDestroy")
	EmployeeBean employeeBean() {
		return new EmployeeBean();
	}

	@Bean
	static AuditBeanPostProcessor auditBeanPostProcessor() { // static: must exist before regular beans
		return new AuditBeanPostProcessor();
	}

	@Bean
	CommandLineRunner run(EmployeeBean employee) {
		return args -> employee.doWork();
	}
}
