package exercises.services;


import exercises.entities.Book;
import exercises.entities.EditionType;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findBooksTitlesByAgeRestrict(String dependency);

    List<String> findTitlesByEditionAndCopies(EditionType gold, int count);

    List<Book> printTitlesAndPricesIn(double a, double b);

    List<Book> findNotReleasedBooks(int releaseDate);

    List<String> printTitlesContaining(String letters);

    List<Book> findByAuthorLastNameStartsWithh(String input);

    int findTitlesBiggerThan(int input);
}
