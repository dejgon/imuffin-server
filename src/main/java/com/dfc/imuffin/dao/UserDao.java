package com.dfc.imuffin.dao;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity
@Table(name = "users")
public class UserDao implements UserDetails {
    @Id
    @Column(name = "user_id")
    @GeneratedValue
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "favorites",joinColumns = {@JoinColumn(name="user_id")},inverseJoinColumns = {@JoinColumn(name="recipe_id")})
    @ElementCollection(fetch = FetchType.EAGER)
    private List<RecipeDao> recipes = new ArrayList<>();

    @OneToOne(mappedBy = "userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private RatingDao rating;

    public UserDao(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UserDao() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new).collect(toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<RecipeDao> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeDao> recipes) {
        this.recipes = recipes;
    }

    public RatingDao getRating() {
        return rating;
    }

    public void setRating(RatingDao rating) {
        this.rating = rating;
    }
}
