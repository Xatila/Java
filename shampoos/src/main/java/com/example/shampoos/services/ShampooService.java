package com.example.shampoos.services;

import com.example.shampoos.entities.Shampoo;
import com.example.shampoos.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findBySize(Size size);

    List<Shampoo> selectBySizeOrLabel(Size size, int labelId);

    List<Shampoo> selectByPrice(BigDecimal price);

    List<Shampoo> selectByIngredientsCount(int count);
}
