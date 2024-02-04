package com.recipe.project.DTO.Week;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recipe.project.DTO.Day.Day;

public class Week {
    @JsonProperty("monday")
    private Day monday;

    @JsonProperty("tuesday")
    private Day tuesday;

    @JsonProperty("wednesday")
    private Day wednesday;

    @JsonProperty("thursday")
    private Day thursday;

    @JsonProperty("friday")
    private Day friday;

    @JsonProperty("saturday")
    private Day saturday;

    @JsonProperty("sunday")
    private Day sunday;

	public Day getMonday() {
		return monday;
	}

	public void setMonday(Day monday) {
		this.monday = monday;
	}

	public Day getTuesday() {
		return tuesday;
	}

	public void setTuesday(Day tuesday) {
		this.tuesday = tuesday;
	}

	public Day getWednesday() {
		return wednesday;
	}

	public void setWednesday(Day wednesday) {
		this.wednesday = wednesday;
	}

	public Day getThursday() {
		return thursday;
	}

	public void setThursday(Day thursday) {
		this.thursday = thursday;
	}

	public Day getFriday() {
		return friday;
	}

	public void setFriday(Day friday) {
		this.friday = friday;
	}

	public Day getSaturday() {
		return saturday;
	}

	public void setSaturday(Day saturday) {
		this.saturday = saturday;
	}

	public Day getSunday() {
		return sunday;
	}

	public void setSunday(Day sunday) {
		this.sunday = sunday;
	}

	
    // getters and setters
    // You can use Lombok to automatically generate getters and setters
}
