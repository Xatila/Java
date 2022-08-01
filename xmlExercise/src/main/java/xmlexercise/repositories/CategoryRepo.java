package xmlexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xmlexercise.models.entitie.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
}
