package com.group2.Arcazon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@ComponentScan("com.group2.Arcazon.service")  

@SpringBootApplication
@EntityScan("com.group2.Arcazon.model")       
@EnableJpaRepositories("com.group2.Arcazon.repository")   
public class GroupProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(GroupProject2Application.class, args);
	}

}
