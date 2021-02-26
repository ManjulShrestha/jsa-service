package com.am.jsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JsaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsaApplication.class, args);
	}

}
