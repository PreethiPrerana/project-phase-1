package com.recipe.project.DTO.Day;

import java.util.List;

import com.recipe.project.DTO.Meals;
import com.recipe.project.DTO.Nutrients;

public class DayResponse {

    private List<Meals> meals;
    private Nutrients nutrients;
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
