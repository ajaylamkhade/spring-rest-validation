package com.javarunner.springrestvalidation.repository;

import com.javarunner.springrestvalidation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserId(Long id);
}
