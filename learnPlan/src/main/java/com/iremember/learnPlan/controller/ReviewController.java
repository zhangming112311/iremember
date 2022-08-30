package com.iremember.learnPlan.controller;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iremember.learnPlan.service.ReviewService;


@RestController
@RequestMapping("/review")
public class ReviewController {
	
	@Resource
	ReviewService reviewService;
	
	@GetMapping("/{userId}")
	public String getReview(@PathVariable("userId") int userId) {
		
		return reviewService.getReview(userId);
	}
}
