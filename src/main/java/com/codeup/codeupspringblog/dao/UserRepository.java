package com.codeup.codeupspringblog.dao;

import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository <User, Long> {

//    Won't return default Optional<User> object
    User findUserById(long id);
    User findUserByUsername(String username);

    @Query("FROM User u WHERE  u.id = :userId")
    User findUserByHisHerNumber(@Param("userId") long userId);
}
