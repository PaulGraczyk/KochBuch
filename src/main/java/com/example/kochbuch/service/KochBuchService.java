package com.example.kochbuch.service;

import com.example.kochbuch.category.Category;
import com.example.kochbuch.category.CategoryDto;
import com.example.kochbuch.category.CategoryRepository;
import com.example.kochbuch.exception.RecipeNotFoundException;
import com.example.kochbuch.recipe.Recipe;
import com.example.kochbuch.recipe.RecipeDescriptionDto;
import com.example.kochbuch.recipe.RecipeItemListDto;
import com.example.kochbuch.recipe.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

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

    public Optional<CategoryDto> getCategoryByCategoryShortcut(String categoryShortcut) {
        return categoryRepository.findCategoryByCategoryShortcutIgnoreCase(categoryShortcut).map(CategoryDto::new);
    }

    public List<RecipeItemListDto> getAllRecipes() {
        return recipeRepository.findAll().stream().map(RecipeItemListDto::new).toList();
    }

    public List<RecipeItemListDto> getAllRecipesFromGivenCategory(CategoryDto category) {
        Category cat = categoryRepository.findById(category.getId()).orElseThrow();
        return recipeRepository.findAllByCategory(cat).stream().map(RecipeItemListDto::new).toList();
    }

    public RecipeDescriptionDto findRecipeById(Long id) {
        Recipe recipe = recipeRepository.findById(id).orElseThrow(RecipeNotFoundException::new);
        return new RecipeDescriptionDto(recipe.getId(), recipe.getRecipeName(), recipe.getIngredients(), recipe.getDescription(),
                recipe.getCategory().getId());
    }

    public List<RecipeItemListDto> findTopRecipes(int size) {
        Pageable page = Pageable.ofSize(size);
        return recipeRepository.findTopByNumberOfLikes(page).stream()
                .map(RecipeItemListDto::new)
                .toList();
    }

    @Transactional
    public void addRecipe(RecipeDescriptionDto recipeDto) {
        Category category = categoryRepository.findById(recipeDto.getCategoryId()).orElseThrow();
        Recipe recipe = new Recipe(recipeDto.getRecipeName(),
                recipeDto.getIngredients(),
                recipeDto.getDescription(),
                category);
        recipeRepository.save(recipe);
    }

    @Transactional
    public void updateRecipe(RecipeDescriptionDto recipeDto) {
        Category category = categoryRepository.findById(recipeDto.getCategoryId()).orElseThrow();
        Recipe recipe = recipeRepository
                .findById(recipeDto.getId())
                .orElseThrow(RecipeNotFoundException::new);
        recipe.setRecipeName(recipeDto.getRecipeName());
        recipe.setIngredients(recipeDto.getIngredients());
        recipe.setDescription(recipeDto.getDescription());
        recipe.setCategory(category);
    }

    @Transactional
    public void deleteRecipeById(Long id) {
        recipeRepository.deleteById(id);
    }


    public void addLikeToRecipe(Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId).orElseThrow(RecipeNotFoundException::new);
        recipe.setNumberOfLikes(recipe.getNumberOfLikes() + 1);
        recipeRepository.save(recipe);
    }
}
