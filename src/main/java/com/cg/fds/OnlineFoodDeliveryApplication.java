package com.cg.fds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.cg.fds.service","com.cg.fds.repository","com.cg.fds.controller"})
@EntityScan("com.cg.fds.entities")
@EnableJpaRepositories("com.cg.fds.repository")
@EnableSwagger2
public class OnlineFoodDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodDeliveryApplication.class, args);
	}
}
