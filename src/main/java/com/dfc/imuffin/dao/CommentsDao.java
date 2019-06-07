package com.dfc.imuffin.dao;

import javax.persistence.*;


@Entity
@Table(name = "comments")
public class CommentsDao {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue
    private Long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipe_id")
    private RecipeDao recipeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private UserDao userId;


}
