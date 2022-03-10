package com.iremember.user.service;

import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.iremember.user.feign.LearnPlanFeign;
import com.iremember.user.model.User;
import com.iremember.user.repository.UserRepository;
import com.iremember.user.vo.UserVO;

@Service
public class UserService {
	@Resource
	UserRepository userRepository;

	@Resource
	LearnPlanFeign learnPlanFeign;
	
	@Resource
	RestTemplate restTemplate;
	
	public UserVO getUser(int id) {
		Optional<User> user = userRepository.findById(id);
		Optional<UserVO> res = user.map(u -> {
			UserVO userVO = new UserVO();
			userVO.setId(u.getId());
			userVO.setName(u.getName());
			userVO.setReview(learnPlanFeign.getReview(u.getId()));
			return userVO;
		});
		return res.orElse(null);
	}
	public UserVO getUser() {
//		restTemplate.exchange("", null);
		return null;
	}
	
}
