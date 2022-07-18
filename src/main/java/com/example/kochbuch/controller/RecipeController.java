package com.example.kochbuch.controller;

import com.example.kochbuch.category.CategoryDto;
import com.example.kochbuch.exception.CategoryNotFoundException;
import com.example.kochbuch.recipe.RecipeDescriptionDto;
import com.example.kochbuch.recipe.RecipeItemListDto;
import com.example.kochbuch.service.KochBuchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RecipeController {

    private static final int BEST_RECIPES_ON_SHOW_NUMBER = 5;

    private final KochBuchService kochBuchService;

    public RecipeController(KochBuchService kochBuchService) {
        this.kochBuchService = kochBuchService;
    }

    @GetMapping("/add-recipe")
    public String addRecipeSite(Model model) {
        List<CategoryDto> categories = kochBuchService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("recipe", new RecipeDescriptionDto());
        return "add-recipe";
    }

    @GetMapping("/add-recipe/{recipeId}")
    public String editRecipeSite(@ PathVariable Long recipeId, Model model) {
        List<CategoryDto> categories = kochBuchService.getAllCategories();
        RecipeDescriptionDto recipe = kochBuchService.findRecipeById(recipeId);
        model.addAttribute("categories", categories);
        model.addAttribute("recipe", recipe);
        return "add-recipe";
    }

    @PostMapping("/save-recipe")
    public String saveRecipe(RecipeDescriptionDto recipeDto) {
        if (recipeDto.getId() != null) {
            kochBuchService.updateRecipe(recipeDto);
        } else {
            kochBuchService.addRecipe(recipeDto);
        }
        return "redirect:/recipes-list/all";
    }

    @GetMapping("/recipes-list/all")
    public String recipesListAll(Model model) {
        List<RecipeItemListDto> recipes = kochBuchService.getAllRecipes();
        model.addAttribute("categoryTitle", "Wszystkie przepisy");
        model.addAttribute("description", "Tu znajdziesz listę wszystkich przepisów.");
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

    @GetMapping("/recipes-list/top")
    public String recipesListTop(Model model) {
        List<RecipeItemListDto> topRecipes = kochBuchService.findTopRecipes(BEST_RECIPES_ON_SHOW_NUMBER);
        model.addAttribute("categoryTitle", "Najlepsze przepisy");
        model.addAttribute("description", "Tu znajdziesz " + BEST_RECIPES_ON_SHOW_NUMBER + " najlepiej ocenianych przepisów.");
        model.addAttribute("recipes", topRecipes);
        return "recipes-list";
    }

    @GetMapping("/recipes-list/{categoryShortcut}")
    public String recipesListByCategory(@PathVariable String categoryShortcut,
                                        Model model) {
        CategoryDto categoryDto = kochBuchService.getCategoryByCategoryShortcut(categoryShortcut).orElseThrow(CategoryNotFoundException::new);
        String categoryTitle = categoryDto.getCategoryTitle();
        String categoryDescription = categoryDto.getDescription();
        List<RecipeItemListDto> recipes = kochBuchService.getAllRecipesFromGivenCategory(categoryDto);
        model.addAttribute("categoryTitle", categoryTitle);
        model.addAttribute("description", categoryDescription);
        model.addAttribute("recipes", recipes);
        return "recipes-list";
    }

    @GetMapping("/recipe-summary/{recipeId}")
    public String recipeSummary(@PathVariable Long recipeId, Model model) {
        RecipeDescriptionDto recipe = kochBuchService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipe-summary";
    }

    @GetMapping("/delete-recipe/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) {
        kochBuchService.deleteRecipeById(recipeId);
        return "redirect:/recipes-list/all";
    }

    @PostMapping("/give-like")
    public String addLike(@RequestParam Long recipeId,
                          @RequestHeader String referer) {
        kochBuchService.addLikeToRecipe(recipeId);
        return "redirect:" + referer;
    }

}
