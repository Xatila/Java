package com.example.shampoos.services;

import com.example.shampoos.entities.Label;
import com.example.shampoos.entities.Shampoo;
import com.example.shampoos.entities.Size;
import com.example.shampoos.repositories.ShampooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ShampooServiceImpl implements ShampooService {

    @Autowired
    private ShampooRepository shampooRepository;

    @Override
    public List<Shampoo> findBySize(Size size) {
        return this.shampooRepository.findBySize(size);
    }

    @Override
    public List<Shampoo> selectBySizeOrLabel(Size size, int labelId) {
      //  Label label = this.labelRepository.findBy(labelId);
            return this.shampooRepository.findBySizeOrLabelIdOrderByPriceAsc(size, labelId);
    }

    @Override
    public List<Shampoo> selectByPrice(BigDecimal price) {
        return this.shampooRepository.findByPriceGreaterThanOrderByPriceDesc(price);
    }

    @Override
    public List<Shampoo> selectByIngredientsCount(int count) {
        return shampooRepository.getCountIngredientsLessThan(count);
    }
}
