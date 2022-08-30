package com.iremember.learnPlan.service;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReviewService {
	
	public String getReview(int userId) {
		log.info("getUser:" + userId + "/" +SecurityContextHolder.getContext().getAuthentication().getName());
		return "review";
	}
}
