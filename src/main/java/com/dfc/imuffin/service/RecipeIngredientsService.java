package com.dfc.imuffin.service;

import com.dfc.imuffin.dto.RecipeDto;
import com.dfc.imuffin.dto.RecipeIngredientsDto;

import java.util.List;

public interface RecipeIngredientsService {
    List<RecipeIngredientsDto> getIngredients(Long recipe_id);
}
