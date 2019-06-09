package com.dfc.imuffin.repository;

import com.dfc.imuffin.dao.RecipeDao;
import com.dfc.imuffin.dao.RecipeIngredientsDao;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface RecipeIngredientsRepository extends CrudRepository<RecipeIngredientsDao, Long> {

    List<RecipeIngredientsDao> findAll();

    List<RecipeIngredientsDao> findAllByRecipeDao_Id(Long id);

}
