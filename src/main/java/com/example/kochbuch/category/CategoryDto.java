package com.example.kochbuch.category;

public class CategoryDto {

    private Long id;

    private String categoryShortcut;

    private String categoryTitle;
    private String description;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.categoryShortcut = category.getCategoryShortcut();
        this.categoryTitle = category.getCategoryTitle();
        this.description = category.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public String getCategoryShortcut() {
        return categoryShortcut;
    }

    public void setCategoryShortcut(String categoryShortcut) {
        this.categoryShortcut = categoryShortcut;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
