package com.redhat.developers;

public class FruitDTO {

    private String name;

    private String season;

    private double carbohydrates;

    private double calories;

    private FruitDTO(String name, String season, double carbohydrates, double calories) {
        this.name = name;
        this.season = season;
        this.carbohydrates = carbohydrates;
        this.calories = calories;
    }

    public static FruitDTO of(Fruit fruit, FruityVice fruityVice) {
        return new FruitDTO(
            fruit.name,
            fruit.season,
            fruityVice.getNutritions().getCarbohydrates(),
            fruityVice.getNutritions().getCalories());
    }

    public String getName() {
        return name;
    }

    public String getSeason() {
        return season;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

}