package com.huarui;


//import tk.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.huarui.dao")
@ComponentScan(basePackages = {"com.huarui","com.huarui.es"})
public class Dishes_App
{

	public static void main(String[] args)
	{
		SpringApplication.run(Dishes_App.class, args);
	}
}
