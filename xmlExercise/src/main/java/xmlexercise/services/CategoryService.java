package xmlexercise.services;

import xmlexercise.models.entitie.Category;
import xmlexercise.models.entitie.DTOs.CategorySeedDTO;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories(List<CategorySeedDTO> categories);

    long getCountEntity();

    Set<Category> getRandomCategory();
}
