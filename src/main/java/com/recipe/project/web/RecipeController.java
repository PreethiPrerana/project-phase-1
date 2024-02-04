package com.recipe.project.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.recipe.project.DTO.RecipeDetails.AnalyzedInstruction;
import com.recipe.project.DTO.RecipeDetails.ExtendedIngredient;
import com.recipe.project.DTO.RecipeDetails.Recipe;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    // @Value("${spoonacular.api.key}")  // Define your API key in application.properties
    private String apiKey="668459505d964573bdefa9396899795c";

    private final RestTemplate restTemplate;

    public RecipeController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getRecipeDetails(@PathVariable String id) {
        String apiUrl = "https://api.spoonacular.com/recipes/{id}/information?apiKey={apiKey}";
        Recipe response = restTemplate.getForObject(apiUrl, Recipe.class, id, apiKey);

        if (response != null) {
            Recipe recipe = new Recipe();
            recipe.setServings(response.getServings());
            recipe.setReadyInMinutes(response.getReadyInMinutes());
            recipe.setImage(response.getImage());

            // Extract only necessary information from extendedIngredients
            List<ExtendedIngredient> extendedIngredients = response.getExtendedIngredients();
            recipe.setExtendedIngredients(extendedIngredients);

            // Extract only necessary information from analyzedInstructions
            List<AnalyzedInstruction> analyzedInstructions = response.getAnalyzedInstructions();
            recipe.setAnalyzedInstructions(analyzedInstructions);

            return ResponseEntity.ok(recipe);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
