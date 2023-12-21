package com.coffee.demoCoffeeApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorldClock {
    private String currentDateTime;
	private String utcOffset;
	private Boolean isDayLightSavingsTime;
	private String dayOfTheWeek;
	private String timeZoneName;
	private Long currentFileTime;
	private String ordinalDate;
	private String serviceResponse;
}
