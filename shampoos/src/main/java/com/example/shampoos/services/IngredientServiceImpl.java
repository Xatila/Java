package com.example.shampoos.services;

import com.example.shampoos.entities.Ingredient;
import com.example.shampoos.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> selectByLetter(String letter) {
       return this.ingredientRepository.findByNameStartingWith(letter);

    }

    @Override
    public List<Ingredient> selectByNames(List<String> names) {
        return ingredientRepository.findByNameInOrderByPriceAsc(names);
    }

    @Override
    public List<Ingredient> updateIngredientsPriceByName(List<String> names) {
        return ingredientRepository.updatePriceByName(names);
    }
}
