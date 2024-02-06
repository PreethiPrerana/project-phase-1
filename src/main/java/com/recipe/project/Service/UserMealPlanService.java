package com.recipe.project.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recipe.project.Entity.UserMealPlan;
import com.recipe.project.Repository.UserMealPlanRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserMealPlanService {
    @Autowired
    private UserMealPlanRepository userMealPlanRepository;

    public void saveUserMealPlan(String userId, String type, Object data) {
        UserMealPlan userMealPlan = new UserMealPlan();
        userMealPlan.setUserId(userId);
        userMealPlan.setType(type);
        userMealPlan.setData(data);
        userMealPlanRepository.save(userMealPlan);
    }
}


