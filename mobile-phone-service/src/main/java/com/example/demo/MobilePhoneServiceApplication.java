package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.MobilePlan;
import com.example.demo.rep0.PlanRepository;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Mobile Plan Manager"))
public class MobilePhoneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilePhoneServiceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner runner() {
		return new CommandLineRunner() {
			
			@Autowired
			PlanRepository repo;
			
			
			@Override
			public void run(String... args) throws Exception {
				// TODO Auto-generated method stub
				
				repo.save(new MobilePlan(102, "PRE-111", 120, "28 days"));
				
			}
		};
	}

}
