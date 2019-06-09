package com.dfc.imuffin.dao;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredientsDao {
    @Id
    @Column(name = "rec_ingr_id")
    @GeneratedValue
    private Long id;

    @Column(name = "amount")
    private String amount;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private IngredientsDao ingredientsDao;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RecipeDao recipeDao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public IngredientsDao getIngredientsDao() {
        return ingredientsDao;
    }

    public void setIngredientsDao(IngredientsDao ingredientsDao) {
        this.ingredientsDao = ingredientsDao;
    }

    public RecipeDao getRecipeDao() {
        return recipeDao;
    }

    public void setRecipeDao(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }
}


