package com.example.shampoos.services;

import com.example.shampoos.entities.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> selectByLetter(String letter);

    List<Ingredient> selectByNames(List<String> names);

    List<Ingredient> updateIngredientsPriceByName(List<String> names);
}
