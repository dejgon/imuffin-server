package com.dfc.imuffin.service.impl;

import com.dfc.imuffin.dao.IngredientsDao;
import com.dfc.imuffin.dao.RecipeDao;
import com.dfc.imuffin.dao.RecipeIngredientsDao;
import com.dfc.imuffin.dto.IngredientsDto;
import com.dfc.imuffin.dto.RecipeDto;
import com.dfc.imuffin.dto.RecipeIngredientsDto;
import com.dfc.imuffin.repository.IngredientsRepository;
import com.dfc.imuffin.repository.RecipeIngredientsRepository;
import com.dfc.imuffin.repository.RecipeRepository;
import com.dfc.imuffin.service.RecipeIngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeIngredientsServiceImpl implements RecipeIngredientsService {
    @Autowired
    RecipeRepository recipeRepo;
    @Autowired
    IngredientsRepository ingrRepo;
    @Autowired
    RecipeIngredientsRepository rcpIngrRepo;

    @Override
    public List<RecipeIngredientsDto> getIngredients(Long recipe_id) {
        List<RecipeIngredientsDao> rcpIngDaoList = rcpIngrRepo.findAllByRecipeDao_Id(recipe_id);
        List<RecipeIngredientsDto> rcpIngDtoList = new ArrayList<>();

        for (RecipeIngredientsDao rcp : rcpIngDaoList){
            IngredientsDao ingredient = ingrRepo.findById(rcp.getIngredientsDao().getId()).get();
            RecipeIngredientsDto rcpIngDto = new RecipeIngredientsDto();
            rcpIngDto.setName(ingredient.getName());
            rcpIngDto.setAmount(rcp.getAmount());
            rcpIngDtoList.add(rcpIngDto);
        }
        return rcpIngDtoList;
    }
}
