package com.dfc.imuffin.repository;

import com.dfc.imuffin.dao.RecipeDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecipeRepository extends CrudRepository<RecipeDao, Long> {

    List<RecipeDao> findAll();

    Optional<RecipeDao> findById(Long id);

    RecipeDao save(RecipeDao recipe);
}
