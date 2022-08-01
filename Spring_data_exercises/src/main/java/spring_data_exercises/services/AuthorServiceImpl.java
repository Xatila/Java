package spring_data_exercises.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_data_exercises.repositories.AuthorRepository;
import spring_data_exercises.entities.Author;

import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Author getRandomAuthor() {

        long size = this.authorRepository.count();
        int authorId = new Random().nextInt((int)size);
        return this.authorRepository.findById(authorId).get();
    }
}
