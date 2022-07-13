package com.example.kochbuch.recipe;

import com.example.kochbuch.category.Category;


public class RecipeDto {

    private Long id;
    private String recipeName;
    private String ingredients;
    private String description;
    private int numberOfLikes;
    private Category category;

    public RecipeDto() {
    }

    public RecipeDto(String recipeName, String ingredients, String description, Category category) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.description = description;
        this.category = category;
    }

    public RecipeDto(Long id, String recipeName, String ingredients, String description, int numberOfLikes, Category category) {
        this.id = id;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.description = description;
        this.numberOfLikes = numberOfLikes;
        this.category = category;
    }

    public RecipeDto(Recipe recipe) {
        this.id = recipe.getId();
        this.recipeName = recipe.getRecipeName();
        this.ingredients = recipe.getIngredients();
        this.description = recipe.getDescription();
        this.numberOfLikes = recipe.getNumberOfLikes();
        this.category = recipe.getCategory();
    }

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
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

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
