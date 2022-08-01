package com.example.shampoos.repositories;

import com.example.shampoos.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findByNameStartingWith(String letter);

    List<Ingredient> findByNameInOrderByPriceAsc(List<String> names);

    @Query(value = "UPDATE ingredients as i SET i.price = i.price+2 where i.name IN :names", nativeQuery = true)
    @Modifying
    List<Ingredient> updatePriceByName(List<String> names);
}
