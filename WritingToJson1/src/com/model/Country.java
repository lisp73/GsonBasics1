package com.model;

import java.util.List;

public class Country {
	String name;
	int population;
	private List<String> listOfStates;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopultion() {
		return this.population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public List<String> getListOfStates() {
		return listOfStates;
	}

	public void setListOfStates(List<String> listOfStates) {
		this.listOfStates = listOfStates;
	}

}
