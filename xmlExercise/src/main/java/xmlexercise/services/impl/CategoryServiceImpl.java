package xmlexercise.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xmlexercise.config.ValidateImpl;
import xmlexercise.models.entitie.Category;
import xmlexercise.models.entitie.DTOs.CategorySeedDTO;
import xmlexercise.repositories.CategoryRepo;
import xmlexercise.services.CategoryService;

import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;
    private final ModelMapper modelMapper;
    private final ValidateImpl validator;


    public CategoryServiceImpl(CategoryRepo categoryRepo, ValidateImpl validator) {
        this.categoryRepo = categoryRepo;
        this.modelMapper = new ModelMapper();
        this.validator = validator;
    }

    @Override
    public void seedCategories(List<CategorySeedDTO> categories) {

            categories.stream().filter(validator::isValid)
                    .map(categorySeedDTO -> modelMapper.map(categorySeedDTO, Category.class))
                    .forEach(categoryRepo::save);

    }

    @Override
    public long getCountEntity() {
        return categoryRepo.count();
    }

    @Override
    public Set<Category> getRandomCategory() {
        Set<Category> categories = new HashSet<>();
        long categoriesCount = categoryRepo.count();
        for (int i = 0; i <=2; i++) {
            long randomId = ThreadLocalRandom.current().nextLong(1, categoriesCount);
            categories.add(categoryRepo.findById(randomId).orElse(null));
        }
        return categories;
    }
}
