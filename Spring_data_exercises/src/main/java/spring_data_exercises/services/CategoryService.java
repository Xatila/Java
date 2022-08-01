package spring_data_exercises.services;

import spring_data_exercises.entities.Category;

import java.util.Set;

public interface CategoryService {
    Set<Category> getRandomCategories();
}
