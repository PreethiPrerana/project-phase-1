package com.recipe.project.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.recipe.project.Entity.MealPlan;

public interface MealPlanRepository extends MongoRepository<MealPlan, String> {
    List<MealPlan> findByUserId(String userId);
}

