package com.example.kochbuch.controller;
import com.example.kochbuch.category.Category;
import com.example.kochbuch.category.CategoryDto;
import com.example.kochbuch.recipe.RecipeDto;
import com.example.kochbuch.service.KochBuchService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class KochBuchController {
    private static final int BEST_RECIPES_NUMBER_ON_SHOW = 5;

    private final KochBuchService kochBuchService;

    public KochBuchController(KochBuchService kochBuchService) {
        this.kochBuchService = kochBuchService;
    }

    @GetMapping("/index")
    public String home() {
        return "index";
    }

    @GetMapping("/add-recipe")
    public String addRecipeSite(Model model) {
        List<CategoryDto> categories = kochBuchService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("recipe", new RecipeDto());
        return "add-recipe";
    }

    @GetMapping("/edit-recipe/{recipeId}")
    public String editForm(@PathVariable Long recipeId, Model model) {
        List<CategoryDto> categories = kochBuchService.getAllCategories();
        RecipeDto recipeDto = kochBuchService.findRecipeById(recipeId);
        model.addAttribute("categories", categories);
        model.addAttribute("recipe", recipeDto);
        return "edit-recipe";
    }


    @PostMapping("/save-recipe")
    public String saveRecipe(@RequestParam String recipeName,
                             @RequestParam String ingredients,
                             @RequestParam String description,
                             @RequestParam String category) {
        Category desiredCategory = kochBuchService.getCategoryByCategoryTitle(category);
        RecipeDto recipeDto = new RecipeDto(recipeName, ingredients, description, desiredCategory);
        kochBuchService.addRecipe(recipeDto);
        return "redirect:/recipes-list/all";
    }

    @PostMapping("/edit-recipe")
    public String updateTask(RecipeDto recipeDto) {
        kochBuchService.updateRecipe(recipeDto);
        return "redirect:/recipes-list/all";
    }

    @GetMapping("/recipes-list/{categoryShortcut}")
    public String recipesList(@PathVariable String categoryShortcut,
                              Model model) {
        if (categoryShortcut.equals("all")) {
            List<RecipeDto> recipes = kochBuchService.getAllRecipes();
            model.addAttribute("categoryTitle", "Wszystkie przepisy");
            model.addAttribute("description", "Tu znajdziesz listę wszystkich przepisów.");
            model.addAttribute("recipes", recipes);
        } else if (categoryShortcut.equals("top")) {
            List<RecipeDto> topRecipes = kochBuchService.findTopRecipes(BEST_RECIPES_NUMBER_ON_SHOW);
            model.addAttribute("categoryTitle", "Najlepsze przepisy");
            model.addAttribute("description", "Tu znajdziesz " + BEST_RECIPES_NUMBER_ON_SHOW + " najlepiej ocenianych przepisów.");
            model.addAttribute("recipes", topRecipes);
        } else {
            Category category = kochBuchService.getCategoryByCategoryShortcut(categoryShortcut);
            String categoryTitle = category.getCategoryTitle();
            String categoryDescription = category.getDescription();
            List<RecipeDto> recipes = kochBuchService.getAllRecipesFromGivenCategory(category);
            model.addAttribute("categoryTitle", categoryTitle);
            model.addAttribute("description", categoryDescription);
            model.addAttribute("recipes", recipes);
        }
        model.addAttribute("categoryShortcut", categoryShortcut);
        return "recipes-list";
    }

    @GetMapping("/recipe-summary/{recipeId}")
    public String recipeSummary(@PathVariable Long recipeId, Model model) {
        RecipeDto recipe = kochBuchService.findRecipeById(recipeId);
        model.addAttribute("recipe", recipe);
        return "recipe-summary";
    }

    @GetMapping("/delete-recipe/{recipeId}")
    public String deleteRecipe(@PathVariable Long recipeId) {
        kochBuchService.deleteById(recipeId);
        return "redirect:/recipes-list/all";
    }

    @PostMapping("/give-like")
    public String addLike (@RequestParam Long recipeId,
                           @RequestHeader String referer) {
        kochBuchService.addLikeToRecipe(recipeId);
        return "redirect:" + referer;
    }
}




