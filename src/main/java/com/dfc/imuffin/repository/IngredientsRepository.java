package com.dfc.imuffin.repository;

import com.dfc.imuffin.dao.IngredientsDao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IngredientsRepository extends CrudRepository<IngredientsDao, Long> {

    List<IngredientsDao> findAll();

    Optional<IngredientsDao> findById(Long id);
}
