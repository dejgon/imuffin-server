package com.dfc.imuffin.dao;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class RecipeDao {
    @Id
    @Column(name = "recipe_id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "url")
    private String url;

    @Column(name = "time_to_prepare")
    private Long timeToPrepare;

    @Column(name = "difficulty")
    private String difficulty;

    @OneToMany(mappedBy = "recipeId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CommentsDao> comments = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_cuisine",joinColumns = {@JoinColumn(name="recipe_id")},inverseJoinColumns = {@JoinColumn(name="cuisineType_id")})
    @ElementCollection(fetch = FetchType.EAGER)
    private List<CuisineTypeDao> ctDao = new ArrayList<>();

    @ManyToMany(mappedBy = "recipes")
    private List<UserDao> users = new ArrayList<>();

    @OneToMany(mappedBy = "ingredientsDao")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RecipeIngredientsDao> ingredients;

    @OneToMany(mappedBy = "recipeId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RatingDao> ratings = new ArrayList<>();

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

    public List<CommentsDao> getComments() {
        return comments;
    }

    public void setComments(List<CommentsDao> comments) {
        this.comments = comments;
    }

    public List<CuisineTypeDao> getCtDao() {
        return ctDao;
    }

    public void setCtDao(List<CuisineTypeDao> ctDao) {
        this.ctDao = ctDao;
    }

    public List<UserDao> getUsers() {
        return users;
    }

    public void setUsers(List<UserDao> users) {
        this.users = users;
    }

    public List<RatingDao> getRatings() {
        return ratings;
    }

    public void setRatings(List<RatingDao> ratings) {
        this.ratings = ratings;
    }

    public List<RecipeIngredientsDao> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<RecipeIngredientsDao> ingredients) {
        this.ingredients = ingredients;
    }
}
