package com.dfc.imuffin.controller;

import com.dfc.imuffin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FavoritesController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/favorites", method = RequestMethod.POST)
    public ResponseEntity addToFavorites(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Long recipeId) {
        Map<Object, Object> response = new HashMap<>();
        userService.addFavorite(userService.getUserByToken(userDetails), recipeId);
        response.put("statusMessage", "Ok");
        response.put("statusCode", "200");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public ResponseEntity getFavorites(@AuthenticationPrincipal UserDetails userDetails) {
        Map<Object, Object> response = new HashMap<>();
        response.put("favorites", userService.getFavorites(userService.getUserByToken(userDetails)));
        response.put("statusMessage", "Ok");
        response.put("statusCode", "200");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "favorites", method = RequestMethod.DELETE)
    public ResponseEntity deleteFromFavorites(@AuthenticationPrincipal UserDetails userDetails, @RequestParam Long recipeId) {
        Map<Object, Object> response = new HashMap<>();
        userService.deleteFromFavorite(userService.getUserByToken(userDetails), recipeId);
        response.put("statusMessage", "Ok");
        response.put("statusCode", "200");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
