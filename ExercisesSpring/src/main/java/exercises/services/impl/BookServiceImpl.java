package exercises.services.impl;


import exercises.entities.*;
import exercises.repositories.BookRepository;
import exercises.services.AuthorService;
import exercises.services.BookService;
import exercises.services.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private static final String BOOKS_FILE_PATH = "src/main/resources/files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files
                .readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookInfo = row.split("\\s+");

                    Book book = createBookFromInfo(bookInfo);

                    bookRepository.save(book);
                });
    }

    @Override
    public List<Book> findAllBooksAfterYear(int year) {
        return bookRepository
                .findAllByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year) {
        return bookRepository
                .findAllByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream()
                .map(book -> String.format("%s %s", book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName) {
       return bookRepository
                .findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream()
                .map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findBooksTitlesByAgeRestrict(String dependency) {

        //AgeRestriction ageRestriction = AgeRestriction.valueOf(dependency.toUpperCase());
        //return this.bookRepository.findBooksTitleByAgeRestrict(ageRestriction);
        return null;
    }

    @Override
    public List<String> findTitlesByEditionAndCopies(EditionType gold, int count) {
        return this.bookRepository.findByEditionTypeAndCopiesLessThan(gold, count).stream().map
                (Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<Book> printTitlesAndPricesIn(double a, double b) {
        BigDecimal low = BigDecimal.valueOf(a);
        BigDecimal high = BigDecimal.valueOf(b);
        return this.bookRepository.findByPriceLessThanOrPriceGreaterThan(low, high);
    }

    @Override
    public List<Book> findNotReleasedBooks(int releaseYear) {
        LocalDate dateOne = LocalDate.of(releaseYear, 1, 1);
        LocalDate datelast = LocalDate.of(releaseYear, 12, 31);

        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(dateOne, datelast);
    }

    @Override
    public List<String> printTitlesContaining(String letters) {
        return this.bookRepository.findByTitleContainingIgnoreCase(letters).stream().map(Book::getTitle).collect(Collectors.toList());
    }

    @Override
    public List<Book> findByAuthorLastNameStartsWithh(String input) {
        return this.bookRepository.findByAuthorLastNameStartsWith(input);
    }

    @Override
    public int findTitlesBiggerThan(int input) {
        return this.bookRepository.findBooksTitleBiggerThan(input);
    }


    private Book createBookFromInfo(String[] bookInfo) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookInfo[0])];
        LocalDate releaseDate = LocalDate
                .parse(bookInfo[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        Integer copies = Integer.parseInt(bookInfo[2]);
        BigDecimal price = new BigDecimal(bookInfo[3]);
        AgeRestriction ageRestriction = AgeRestriction
                .values()[Integer.parseInt(bookInfo[4])];
        String title = Arrays.stream(bookInfo)
                .skip(5)
                .collect(Collectors.joining(" "));

        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService
                .getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);

    }
}
