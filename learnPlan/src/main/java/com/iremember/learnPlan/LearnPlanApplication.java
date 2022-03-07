package com.iremember.learnPlan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LearnPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnPlanApplication.class, args);
	}
}
