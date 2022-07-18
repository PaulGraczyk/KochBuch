package com.example.kochbuch.recipe;

import java.time.LocalDate;

public class RecipeItemListDto {

    private Long id;
    private String recipeName;
    private int numberOfLikes;
    private LocalDate dateAdded;

    public RecipeItemListDto(Recipe recipe) {
        this.id = recipe.getId();
        this.recipeName = recipe.getRecipeName();
        this.numberOfLikes = recipe.getNumberOfLikes();
        this.dateAdded = recipe.getDateAdded();
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

    public int getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(int numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }
}


