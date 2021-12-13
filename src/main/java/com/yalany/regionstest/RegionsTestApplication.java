package com.yalany.regionstest;

import com.yalany.regionstest.model.Region;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MappedTypes(Region.class)
@MapperScan("com.yalany.regionstest.mapper")
@SpringBootApplication
@EnableCaching
public class RegionsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegionsTestApplication.class, args);
	}
}
