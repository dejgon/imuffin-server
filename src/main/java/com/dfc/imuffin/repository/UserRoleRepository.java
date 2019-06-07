package com.dfc.imuffin.repository;

import com.dfc.imuffin.dao.UserRoleDao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRoleRepository extends CrudRepository<UserRoleDao, Long> {

    @Override
    UserRoleDao save(UserRoleDao userRoles);

    @Override
    Optional<UserRoleDao> findById(Long id);

}