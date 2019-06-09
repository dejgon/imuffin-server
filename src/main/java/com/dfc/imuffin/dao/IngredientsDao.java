package com.dfc.imuffin.dao;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class IngredientsDao {
    @Id
    @Column(name = "ingredient_id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "ingr_cat_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private IngredientsCategoriesDao ingCat;

    @OneToMany(mappedBy = "ingredientsDao")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RecipeIngredientsDao> recipeIngredientsDaoList;


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

    public IngredientsCategoriesDao getIngCat() {
        return ingCat;
    }

    public void setIngCat(IngredientsCategoriesDao ingCat) {
        this.ingCat = ingCat;
    }

    public List<RecipeIngredientsDao> getRecipeIngredientsDaoList() {
        return recipeIngredientsDaoList;
    }

    public void setRecipeIngredientsDaoList(List<RecipeIngredientsDao> recipeIngredientsDaoList) {
        this.recipeIngredientsDaoList = recipeIngredientsDaoList;
    }
}
