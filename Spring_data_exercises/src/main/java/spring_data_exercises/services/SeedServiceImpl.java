package spring_data_exercises.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_data_exercises.repositories.AuthorRepository;
import spring_data_exercises.repositories.BookRepository;
import spring_data_exercises.repositories.CategoryRepository;
import spring_data_exercises.entities.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SeedServiceImpl implements SeedService {

    private static final String PATH = "src\\main\\resources\\files";
    private static final String AUTHOR_PATH = PATH + "\\authors.txt";
    private static final String BOOKS_PATH = PATH + "\\books.txt";
    private static final String CATEGORIES_PATH = PATH + "\\categories.txt";

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryRepository categoryRepository;


    @Autowired
    private BookRepository bookRepository;

    private CategoryService categoryService;


    @Override
    public void seedAuthor() throws IOException {
        Files.readAllLines(Path.of(AUTHOR_PATH)).stream()
                .filter(s -> !s.isBlank())
                .map(names -> names.split(" "))
                .map(names -> new Author(names[0], names[1]))
                .forEach(authorRepository::save);
    }

    @Override
    public void seedCategories() throws IOException {
        Files.readAllLines(Path.of(CATEGORIES_PATH)).stream()
                .filter(s -> !s.isBlank())
                .map(Category::new)
                .forEach(categoryRepository::save);
    }

    @Override
    public void seedBooks() throws IOException {


        Files.readAllLines(Path.of(BOOKS_PATH))
                .forEach(row -> {
                    String[] data = row.split("\\s+");
                    Author author = authorService.getRandomAuthor();
                    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
                    LocalDate releaseDate = LocalDate.parse(data[1],
                            DateTimeFormatter.ofPattern("d/M/yyyy"));
                    int copies = Integer.parseInt(data[2]);
                    BigDecimal price = new BigDecimal(data[3]);
                    AgeRestriction ageRestriction = AgeRestriction
                            .values()[Integer.parseInt(data[4])];
                    String title = Arrays.stream(data)
                            .skip(5)
                            .collect(Collectors.joining(" "));
                    Set<Category> categories = categoryService.getRandomCategories();

                    Book book = new Book(title, editionType, price, releaseDate,
                            ageRestriction, author, categories, copies);

                    bookRepository.save(book);
                });
    }
}
