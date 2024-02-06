package com.recipe.project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.project.Service.UserMealPlanService;

@RestController
public class UserMealPlanController {
    @Autowired
    private UserMealPlanService userMealPlanService;

    @PostMapping("/user/{userId}/meal-plan/{type}")
    public void saveUserMealPlan(@PathVariable String userId, @PathVariable String type, @RequestBody Object data) {
        userMealPlanService.saveUserMealPlan(userId, type, data);
    }
}
