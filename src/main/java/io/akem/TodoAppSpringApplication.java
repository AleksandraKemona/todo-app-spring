package io.akem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import jakarta.validation.Validator;

@SpringBootApplication
public class TodoAppSpringApplication {

	public static void main(String[] args) {SpringApplication.run(TodoAppSpringApplication.class, args); }

	@Bean
	Validator validator() {
		return new LocalValidatorFactoryBean();
	}
}
