package spring_data_exercises.services;

import java.io.IOException;

public interface SeedService {
    void seedAuthor() throws IOException;

    void seedBooks() throws IOException;

    void seedCategories() throws IOException;

    default void seedAll() throws IOException {
        seedAuthor();
        seedCategories();
        seedBooks();
    }
}
