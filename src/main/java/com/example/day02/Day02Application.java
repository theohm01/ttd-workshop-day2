package com.example.day02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Day02Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx =  SpringApplication.run(Day02Application.class, args);
		System.out.println(ctx.getBeanDefinitionCount());
//		for (String name : ctx.getBeanDefinitionNames()) {
//			System.out.println(name);
//		}
			
	}

}
