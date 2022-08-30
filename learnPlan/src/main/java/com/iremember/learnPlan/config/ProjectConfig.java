package com.iremember.learnPlan.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAsync
public class ProjectConfig extends WebSecurityConfigurerAdapter {
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest()
//	     .access("hasIpAddress('127.0.0.1') or hasIpAddress('x.x.x.x')");
		.access("hasIpAddress('192.168.50.181')");
	}
}