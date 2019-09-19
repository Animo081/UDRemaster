package com.vector.udremaster.repository;

import com.vector.udremaster.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLoginAndPassword(@Param("login") String login, @Param("password") String password);
}
