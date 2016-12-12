package com.me.light;

import java.util.Scanner;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	private Scanner sc = new Scanner(System.in);
	
	@Bean
	public Scanner scanner(){
		 return sc;
	}
	
	@PreDestroy
	public void clean(){
		sc.close();
	}
}
