package com.dfc.imuffin.controller;

import com.dfc.imuffin.service.RecipeIngredientsService;
import com.dfc.imuffin.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RecipeController {

    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeIngredientsService rcpIngService;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public ResponseEntity getRecipes() {
        Map<Object, Object> response = new HashMap<>();
        response.put("recipes", recipeService.getAllRecipes());
        response.put("statusMessage", "Ok");
        response.put("statusCode", "200");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    public ResponseEntity getSkiValley(@RequestParam Long id) {
        Map<Object, Object> response = new HashMap<>();
        response.put("recipe", recipeService.getRecipe(id));
        response.put("ingredients", rcpIngService.getIngredients(id));
        response.put("statusMessage", "Ok");
        response.put("statusCode", "200");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
