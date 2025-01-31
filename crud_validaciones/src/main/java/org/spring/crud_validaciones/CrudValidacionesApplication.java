package org.spring.crud_validaciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CrudValidacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudValidacionesApplication.class, args);
	}

}
