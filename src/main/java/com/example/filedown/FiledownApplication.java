package com.example.filedown;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
//开启事务，使用时将@Transactional 注解加到service实现类上
@EnableTransactionManagement
//必须加这个，不加报错，如果不加，也可以在每个mapper上添加@Mapper注释
@MapperScan("com.example.filedown.mapper")
public class FiledownApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiledownApplication.class, args);
	}
}
