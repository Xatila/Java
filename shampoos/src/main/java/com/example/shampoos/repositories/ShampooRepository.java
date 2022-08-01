package com.example.shampoos.repositories;

import com.example.shampoos.entities.Shampoo;
import com.example.shampoos.entities.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {
    //List<Shampoo> findBySizeOrderById(Size size);
    List<Shampoo> findBySize(Size size);

    List<Shampoo> findBySizeOrLabelIdOrderByPriceAsc(Size size, long labelId);

    List<Shampoo> findByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    @Query("SELECT s from Shampoo as s WHERE s.ingredients.size < :count")
    List<Shampoo> getCountIngredientsLessThan(int count);
}
