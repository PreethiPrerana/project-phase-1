package com.recipe.project.Entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.recipe.project.DTO.Meals;
import com.recipe.project.DTO.Nutrients;

@Document(collection = "mealPlans")
public class MealPlan {
    @Id
    private String id;
    private String userId;
    private List<Meals> meals;
    private Nutrients nutrients;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public List<Meals> getMeals() {
        return meals;
    }
    public void setMeals(List<Meals> meals) {
        this.meals = meals;
    }
    public Nutrients getNutrients() {
        return nutrients;
    }
    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }
    
    
}
