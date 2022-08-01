package productshopApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productshopApp.entities.products.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
