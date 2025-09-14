package com.interstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.interstage.mapper")
public class InterstageApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterstageApplication.class, args);
	}

}
