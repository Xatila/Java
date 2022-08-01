package spring_data_exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_data_exercises.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
