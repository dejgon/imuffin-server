package com.dfc.imuffin.dao;

import org.hibernate.annotations.*;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "recipe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CommentsDao> comments = new ArrayList<>();

    @OneToMany(mappedBy = "recipe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RecipeIngredientsDao> recipeIngredients = new ArrayList<>();

    @OneToMany(mappedBy = "recipe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CommentsDao> comments = new ArrayList<>();

    @OneToMany(mappedBy = "recipe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RatingDao> ratings = new ArrayList<>();

}
