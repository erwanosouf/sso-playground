package com.yekrik.poc.sso.dao;

import com.yekrik.poc.sso.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<User, Long> {


}
