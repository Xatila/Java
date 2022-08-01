package spring_data_exercises.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_data_exercises.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
