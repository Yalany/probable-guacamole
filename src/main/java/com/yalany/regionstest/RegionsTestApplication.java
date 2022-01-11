package com.yalany.regionstest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.yalany.regionstest.mapper")
@SpringBootApplication
@EnableCaching
public class RegionsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionsTestApplication.class, args);
	}
}
