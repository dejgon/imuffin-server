package com.dfc.imuffin.dto;

import com.dfc.imuffin.dao.IngredientsDao;

import java.io.Serializable;
import java.util.List;

public class RecipeDto implements Serializable {

    private Long id;
    private String name;
    private String content;
    private String url;
    private Long timeToPrepare;
    private String difficulty;
    private List<IngredientsDao> ingredients;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getTimeToPrepare() {
        return timeToPrepare;
    }

    public void setTimeToPrepare(Long timeToPrepare) {
        this.timeToPrepare = timeToPrepare;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public List<IngredientsDao> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsDao> ingredients) {
        this.ingredients = ingredients;
    }
}
