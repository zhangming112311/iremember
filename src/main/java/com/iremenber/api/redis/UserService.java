package com.iremenber.api.redis;

import com.iremenber.api.vo.User;
import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Author: zm
 * @Date: 2019/9/23 17:12
 * @Version: 1.0
 */
public class UserService {
    @Reference
    private RedisTemplate redisTemplate;
    public User getUserByName(String userName){
//        redisTemplate.ops
        return null;
    }
}
