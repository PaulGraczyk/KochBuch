package com.example.kochbuch.category;

import com.example.kochbuch.recipe.Recipe;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String categoryShortcut;
    private String categoryTitle;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Recipe> recipes;

    public Category() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryShortcut() {
        return categoryShortcut;
    }

    public void setCategoryShortcut(String name) {
        this.categoryShortcut = name;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}



