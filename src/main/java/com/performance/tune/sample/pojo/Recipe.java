package com.performance.tune.sample.pojo;

import java.util.OptionalInt;

public class Recipe {
    private String recipeName;
    private OptionalInt calories;
    // Optional number of calories.
    public String getRecipeName() { return recipeName; }
    public OptionalInt getCalories() { return calories; }
    public Recipe(String recipeName, OptionalInt calories) {
        this.recipeName = recipeName;
        this.calories = calories;
    }
}
