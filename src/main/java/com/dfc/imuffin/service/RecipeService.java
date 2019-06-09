package com.dfc.imuffin.service;


import com.dfc.imuffin.dto.RecipeDto;

import java.util.List;

public interface RecipeService {

    List<RecipeDto> getAllRecipes();

    RecipeDto getRecipe(Long id);
}
