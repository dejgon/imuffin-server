package com.dfc.imuffin.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe_ingredients")
public class RecipeIngredientsDao {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private List<RecipeDao> recipes = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private List<IngredientsDao> ingredients = new ArrayList<>();

    @Column(name = "amount")
    private float amount;
}
