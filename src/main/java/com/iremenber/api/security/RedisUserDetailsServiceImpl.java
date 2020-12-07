package com.iremenber.api.security;

import org.springframework.data.annotation.Reference;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @Author: zm
 * @Date: 2019/9/23 16:45
 * @Version: 1.0
 */
public class RedisUserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDetails user = redisTemplate.ops
        UserDetails user = null;
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

//        return new User(user.getUsername(), user.getPassword(), user.isEnabled(),
//                user.isAccountNonExpired(), user.isCredentialsNonExpired(),
//                user.isAccountNonLocked(), user.getAuthorities());
        return user;
    }
}
