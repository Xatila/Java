package xmlexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xmlexercise.models.entitie.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
}
