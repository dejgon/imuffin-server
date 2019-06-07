package com.dfc.imuffin.dao;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
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

}
