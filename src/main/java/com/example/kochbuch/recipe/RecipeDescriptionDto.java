package com.example.kochbuch.recipe;

public class RecipeDescriptionDto {

    private Long id;
    private String recipeName;
    private String ingredients;
    private String description;
    private Long categoryId;
    private boolean isGlutenFree;

    public RecipeDescriptionDto() {
    }

    public RecipeDescriptionDto(Long id, String recipeName, String ingredients, String description, Long categoryId, boolean isGlutenFree) {
        this.id = id;
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.description = description;
        this.categoryId = categoryId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public boolean isGlutenFree() {
        return isGlutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        isGlutenFree = glutenFree;
    }
}
