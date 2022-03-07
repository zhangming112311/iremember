package com.iremember.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("learnPlan")
public interface LearnPlanFeign {
	@GetMapping("/review/{userId}")
	String getReview(@PathVariable("userId") int userId);
}