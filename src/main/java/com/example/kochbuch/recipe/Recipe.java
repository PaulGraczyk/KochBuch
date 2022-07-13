package com.example.kochbuch.recipe;

import com.example.kochbuch.category.Category;

import javax.persistence.*;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String recipeName;
    @Column(length = 500)
    private String ingredients;
    @Column(length = 1500)
    private String description;
    private int numberOfLikes;
    @ManyToOne
    private Category category;

    public Recipe() {
    }

    public Recipe(String recipeName, String ingredients, String description, Category category) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.description = description;
        this.numberOfLikes = 0;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String name) {
        this.recipeName = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingrediendsList) {
        this.ingredients = ingrediendsList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}



