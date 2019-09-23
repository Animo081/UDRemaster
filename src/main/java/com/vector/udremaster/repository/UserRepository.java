package com.vector.udremaster.repository;

import com.vector.udremaster.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByLogin(@Param("login") String login);

    @Query("SELECT password FROM User WHERE login = :login")
    String getPasswordByLogin(@Param("login") String login);

    @Query("SELECT password FROM User WHERE userId = :userId")
    String getPasswordById(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query("UPDATE User SET username = :username WHERE userId = :userId")
    void updateUsernameById(@Param("username") String username, @Param("userId") long userId);

    @Modifying
    @Transactional
    @Query("UPDATE User SET description = :description WHERE userId = :userId")
    void updateDescriptionById(@Param("description") String description, @Param("userId") long userId);

    @Modifying
    @Transactional
    @Query("UPDATE User SET email = :email WHERE userId = :userId")
    void updateEmailById(@Param("email") String email, @Param("userId") long userId);

    @Modifying
    @Transactional
    @Query("UPDATE User SET password = :password WHERE userId = :userId")
    void updatePasswordById(@Param("password") String password, @Param("userId") long userId);
}
