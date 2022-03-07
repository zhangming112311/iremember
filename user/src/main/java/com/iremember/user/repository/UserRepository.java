package com.iremember.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iremember.user.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}