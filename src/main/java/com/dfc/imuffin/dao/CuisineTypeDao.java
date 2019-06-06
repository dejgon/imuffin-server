package com.dfc.imuffin.dao;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cuisine_type")
public class CuisineTypeDao {
    @Id
    @Column(name = "cuisine_id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "cuisine_type_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<RecipeCuisineDao> recipeCuisines = new ArrayList();

    public CuisineTypeDao() {
    }

    public CuisineTypeDao(String name, List<RecipeCuisineDao> recipeCuisines) {
        this.name = name;
        this.recipeCuisines = recipeCuisines;
    }

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

    public List<RecipeCuisineDao> getRecipeCuisines() {
        return recipeCuisines;
    }

    public void setRecipeCuisines(List<RecipeCuisineDao> recipeCuisines) {
        this.recipeCuisines = recipeCuisines;
    }
}
