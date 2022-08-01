package spring_data_exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import spring_data_exercises.repositories.CategoryRepository;
import spring_data_exercises.entities.Category;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new  Random();
        long size = this.categoryRepository.count();
        int categoriesCount = random.nextInt((int)size)+1;
        Set<Integer> categoriesIds = new HashSet<>();
        for (int i = 0; i < categoriesCount ; i++) {
         int nextId = random.nextInt((int)size)+1;
         categoriesIds.add(nextId);
        }

        List<Category> ids = this.categoryRepository.findAllById(categoriesIds);
        return new HashSet<>(ids);
    }
}
