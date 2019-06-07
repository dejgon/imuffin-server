package com.dfc.imuffin.dao;

import javax.persistence.*;

@Entity
@Table(name = "ratings")
public class RatingDao {
    @Id
    @Column(name = "rating_id")
    @GeneratedValue
    private Long id;

    @Column(name = "rating")
    private Long rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private RecipeDao recipeId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserDao userId;

}
