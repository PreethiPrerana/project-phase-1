package com.recipe.project.DTO.RecipeDetails;

import java.util.List;

public class RecipeDetailsDTO {
    private int servings;
    private int readyInMinutes;
    private String image;
    private List<IngredientDTO> extendedIngredients;
    private String instructions;

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public int getReadyInMinutes() {
        return readyInMinutes;
    }

    public void setReadyInMinutes(int readyInMinutes) {
        this.readyInMinutes = readyInMinutes;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<IngredientDTO> getExtendedIngredients() {
        return extendedIngredients;
    }

    public void setExtendedIngredients(List<IngredientDTO> extendedIngredients) {
        this.extendedIngredients = extendedIngredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
