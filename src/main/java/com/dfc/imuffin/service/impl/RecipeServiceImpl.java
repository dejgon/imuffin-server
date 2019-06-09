package com.dfc.imuffin.service.impl;

import com.dfc.imuffin.dao.IngredientsDao;
import com.dfc.imuffin.dao.RecipeDao;
import com.dfc.imuffin.dto.RecipeDto;
import com.dfc.imuffin.repository.IngredientsRepository;
import com.dfc.imuffin.repository.RecipeRepository;
import com.dfc.imuffin.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeRepository recipeRepo;
    @Autowired
    IngredientsRepository ingrRepo;

    @Override
    public List<RecipeDto> getAllRecipes() {
        List<RecipeDao> recipesDaoList = recipeRepo.findAll();
        List<RecipeDto> recipesDtoList = new ArrayList<>();

        for(RecipeDao recipeDao : recipesDaoList) {
            RecipeDto recipeDto = new RecipeDto();
            recipeDto.setId(recipeDao.getId());
            recipeDto.setName(recipeDao.getName());
            recipeDto.setContent(recipeDao.getContent());
            recipeDto.setUrl(recipeDao.getUrl());
            recipeDto.setTimeToPrepare(recipeDao.getTimeToPrepare());
            recipeDto.setDifficulty(recipeDao.getDifficulty());
            recipesDtoList.add(recipeDto);
        }
        return recipesDtoList;
    }

    @Override
    public RecipeDto getRecipe(Long id) {


        RecipeDao recipeDao = recipeRepo.findById(id).get();
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(recipeDao.getId());
        recipeDto.setName(recipeDao.getName());
        recipeDto.setContent(recipeDao.getContent());
        recipeDto.setUrl(recipeDao.getUrl());
        recipeDto.setTimeToPrepare(recipeDao.getTimeToPrepare());
        recipeDto.setDifficulty(recipeDao.getDifficulty());
        return recipeDto;
    }
}
