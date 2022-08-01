package com.example.shampoos;

import com.example.shampoos.entities.Ingredient;
import com.example.shampoos.entities.Size;
import com.example.shampoos.repositories.ShampooRepository;
import com.example.shampoos.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.shampoos.services.ShampooService;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ConsoleRun implements CommandLineRunner {


    private final IngredientService ingredientService;
   private final ShampooService shampooService;

    @Autowired
    public ConsoleRun( IngredientService ingredientService, ShampooService shampooService) {
        this.ingredientService= ingredientService;
       this.shampooService = shampooService;
    }

    @Override
    public void run(String... args) throws Exception {

        //this.shampooService.findBySize(Size.MEDIUM).forEach(System.out::println);
        //this.shampooService.selectBySizeOrLabel(Size.MEDIUM, 10).forEach(System.out::println);
       // this.shampooService.selectByPrice(BigDecimal.valueOf(5)).forEach(System.out::println);
       // this.ingredientService.selectByLetter("M").forEach(System.out::println);
        //this.shampooService.selectByIngredientsCount(2).forEach(System.out::println);
        this.ingredientService.updateIngredientsPriceByName(List.of("Apple"+"Nettle"));



    }
}
