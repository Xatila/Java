package productshopApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productshopApp.entities.categories.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
