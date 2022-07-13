package com.example.kochbuch.service;

import com.example.kochbuch.category.Category;
import com.example.kochbuch.category.CategoryDto;
import com.example.kochbuch.category.CategoryRepository;
import com.example.kochbuch.exception.CategoryNotFoundException;
import com.example.kochbuch.exception.RecipeNotFoundException;
import com.example.kochbuch.recipe.Recipe;
import com.example.kochbuch.recipe.RecipeDto;
import com.example.kochbuch.recipe.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class KochBuchService {

    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;

    public KochBuchService(CategoryRepository categoryRepository, RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
    }

    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream().map(CategoryDto::new).toList();
    }

    public List<RecipeDto> getAllRecipes() {
        return recipeRepository.findAll().stream().map(RecipeDto::new).toList();
    }

    public List<RecipeDto> getAllRecipesFromGivenCategory(Category category) {
        return category.getRecipes().stream().map(RecipeDto::new).toList();
    }

    public RecipeDto findRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
        return new RecipeDto(recipe.getId(), recipe.getRecipeName(), recipe.getIngredients(), recipe.getDescription(),
                recipe.getNumberOfLikes(), recipe.getCategory());
    }

    public List<RecipeDto> findTopRecipes(int size) {
        Pageable page = Pageable.ofSize(size);
        return recipeRepository.findTopByNumberOfLikes(page).stream()
                .map(RecipeDto::new)
                .toList();

    }

    @Transactional
    public void addRecipe(RecipeDto recipeDto) {
        Recipe recipe = new Recipe(recipeDto.getRecipeName(),
                recipeDto.getIngredients(),
                recipeDto.getDescription(),
                recipeDto.getCategory());
        recipeRepository.save(recipe);
    }

    @Transactional
    public void updateRecipe(RecipeDto recipeDto) {
        Recipe recipe = recipeRepository
                .findById(recipeDto.getId())
                .orElseThrow(RecipeNotFoundException::new);
        recipe.setRecipeName(recipeDto.getRecipeName());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setCategory(recipeDto.getCategory());
    }

    @Transactional
    public void deleteById(Long id) {
        recipeRepository.deleteById(id);
    }

    public Category getCategoryByCategoryTitle(String categoryTitle) {
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getCategoryTitle().equals(categoryTitle)) {
                return category;
            }
        }
        throw new CategoryNotFoundException();
    }

    public Category getCategoryByCategoryShortcut(String categoryShortcut) {
        List<Category> categories = categoryRepository.findAll();
        for (Category category : categories) {
            if (category.getCategoryShortcut().equals(categoryShortcut)) {
                return category;
            }
        }
        throw new CategoryNotFoundException();
    }

    public void addLikeToRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new);
        recipe.setNumberOfLikes(recipe.getNumberOfLikes() + 1);
        recipeRepository.save(recipe);
    }
}
