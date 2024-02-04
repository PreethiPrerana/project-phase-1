package com.recipe.project.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.recipe.project.DTO.Day.DayResponse;
import com.recipe.project.DTO.Week.WeekResponse;

import java.net.URI;

@RestController
public class MealController {

    @Value("${spoonacular.urls.baseurl}")
    private String baseURL;

    @Value("${apikey}")
    private String apiKey;

    private final RestTemplate restTemplate;

    public MealController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/mealplanner/day")
    public ResponseEntity<DayResponse> getDayMeals(
            @RequestParam String targetCalories,
            @RequestParam String diet,
            @RequestParam String exclusions) {

        URI uri = UriComponentsBuilder.fromHttpUrl(baseURL)
                .queryParam("timeFrame", "day")
                .queryParam("targetCalories", targetCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .queryParam("apiKey", apiKey)
                .build()
                .toUri();

        ResponseEntity<DayResponse> response = restTemplate.getForEntity(uri, DayResponse.class);
        return response;
    }

    @GetMapping("/mealplanner/week")
    public ResponseEntity<WeekResponse> getWeekMeals(
            @RequestParam String targetCalories,
            @RequestParam String diet,
            @RequestParam String exclusions) {

        URI uri = UriComponentsBuilder.fromHttpUrl(baseURL)
                .queryParam("timeFrame", "week")
                .queryParam("targetCalories", targetCalories)
                .queryParam("diet", diet)
                .queryParam("exclude", exclusions)
                .queryParam("apiKey", apiKey)
                .build()
                .toUri();

        ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);
        return response;
    }

}
