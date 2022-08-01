package exercises.services;


import exercises.entities.Author;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsOrderByCountOfTheirBooks();

    List<String> printNamesEndsWith(String letter);
}
