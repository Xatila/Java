package xmlexercise.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xmlexercise.models.entitie.User;
@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
