package com.faidihr.mobile.app.api.model.repository;

import com.faidihr.mobile.app.api.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

   public User findUserByEmailAndPasswordHashAndStatus(String email, String password, Integer status);

   public User findUserByEmailAndStatus(String email,  Integer status);

}
