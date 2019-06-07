package com.dfc.imuffin.repository;

import com.dfc.imuffin.dao.UserDao;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends CrudRepository<UserDao, Long> {

    Optional<UserDao> findByUsername(String username);

    Optional<UserDao> findByEmail(String email);


    @Override
    UserDao save(UserDao userDao);

    @Modifying
    @Transactional
    @Query(value = "UPDATE users set email=:email , user_name=:username, password=:password where user_id=:user_id", nativeQuery = true)
    void updateUserById(@Param("email") String email, @Param("username") String username, @Param("password") String password, @Param("user_id") Long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE user_id=:user_id", nativeQuery = true)
    void deleteUserById(@Param("user_id") Long id);

}