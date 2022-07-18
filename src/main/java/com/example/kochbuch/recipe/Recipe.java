package com.example.kochbuch.recipe;

import com.example.kochbuch.category.Category;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate dateAdded;

    private boolean isGlutenFree;

    public Recipe() {
    }

    public Recipe(String recipeName, String ingredients, String description, Category category, boolean isGlutenFree) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.description = description;
        this.numberOfLikes = 0;
        this.category = category;
        this.dateAdded = LocalDate.now();
        this.isGlutenFree = isGlutenFree;
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

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDate(LocalDate timeAdded) {
        this.dateAdded = timeAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }
}



