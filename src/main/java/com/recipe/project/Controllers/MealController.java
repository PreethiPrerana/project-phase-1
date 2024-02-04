package com.recipe.project.Controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.recipe.project.DTO.Day.DayResponse;
import com.recipe.project.DTO.Week.WeekResponse;

@RestController
public class MealController {

	// Add base for the unchanging part of your web address.
	@Value("${spoonacular.urls.baseurl}")
	private String baseURL;

	@Value("${apikey}")
	private String apiKey;

	@GetMapping("/mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam Optional<String> targetCalories,
			@RequestParam Optional<String> diet,
			@RequestParam Optional<String> exclusions) {
		RestTemplate rt = new RestTemplate();

		URI uri = UriComponentsBuilder.fromHttpUrl(baseURL)
				.queryParam("timeFrame", "day")
				.queryParamIfPresent("targetCalories", targetCalories)
				.queryParamIfPresent("diet", diet)
				.queryParamIfPresent("exclude", exclusions)
				.queryParam("apiKey", apiKey)
				.build()
				.toUri();

		ResponseEntity<DayResponse> response = rt.getForEntity(uri, DayResponse.class);
		return response;
	}

	@GetMapping("/mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(required = false) String targetCalories,
			@RequestParam(required = false) String diet,
			@RequestParam(required = false) String exclusions) {

		RestTemplate restTemplate = new RestTemplate();

		URI uri = UriComponentsBuilder.fromHttpUrl(baseURL)
				.queryParam("timeFrame", "week")
				.queryParamIfPresent("targetCalories", Optional.ofNullable(targetCalories))
				.queryParamIfPresent("diet", Optional.ofNullable(diet))
				.queryParamIfPresent("exclude", Optional.ofNullable(exclusions))
				.queryParam("apiKey", apiKey)
				.build()
				.toUri();

		ResponseEntity<WeekResponse> response = restTemplate.getForEntity(uri, WeekResponse.class);

		return response;
	}
}