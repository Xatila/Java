package spring_data_exercises.services;

import org.springframework.stereotype.Repository;
import spring_data_exercises.entities.Author;


public interface AuthorService {
    Author getRandomAuthor();
}
