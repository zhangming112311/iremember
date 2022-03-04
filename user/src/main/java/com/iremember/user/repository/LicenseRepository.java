package com.iremember.user.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iremember.user.model.User;


@Repository
public interface LicenseRepository extends CrudRepository<User, String> {
}