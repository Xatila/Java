package productshopApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import productshopApp.entities.users.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
