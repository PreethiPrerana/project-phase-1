package com.recipe.project.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import com.recipe.project.Entity.UserMealPlan;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMealPlanRepository extends MongoRepository<UserMealPlan, String> {
    // Add custom query methods if needed
}
