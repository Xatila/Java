package exercises;

import exercises.entities.AgeRestriction;
import exercises.entities.Book;
import exercises.entities.EditionType;
import exercises.services.AuthorService;
import exercises.services.BookService;
import exercises.services.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        //seedData();

         //printAllBooksAfterYear(2000);
         //printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
         //printAllAuthorsAndNumberOfTheirBooks();
        //pritnALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
        Scanner scanner = new Scanner(System.in);

        //1
        //String parameter = scanner.nextLine();
        //this.bookService.findBooksTitlesByAgeRestrict(parameter).forEach(System.out::println);

        //2
        //this.bookService.findTitlesByEditionAndCopies(EditionType.GOLD, 5000).forEach(System.out::println);

        //3
        //this.bookService.printTitlesAndPricesIn(5, 45).forEach(b-> System.out.println(b.getTitle() + " - " + b.getPrice()));

        //4
        //int releaseYear = Integer.parseInt(scanner.nextLine());
        //this.bookService.findNotReleasedBooks(releaseYear).forEach(b-> System.out.println(b.getTitle()));

        //5
        //LocalDate datetoFormat = LocalDate.of("1992","04","12");
        //DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //String formattedDate = datetoFormat.format(myFormatObj);
        //System.out.println(formattedDate);

        //6
        //String letter = scanner.nextLine();
        //this.authorService.printNamesEndsWith(letter).forEach(System.out::println);

        //7
        //String letters = scanner.nextLine();
        //this.bookService.printTitlesContaining(letters).forEach(System.out::println);

        //8
        //String input = scanner.nextLine();
        //this.bookService.findByAuthorLastNameStartsWithh(input)
        //.forEach(b-> System.out.printf("%s (%s %s)\n",b.getTitle(),b.getAuthor().getFirstName(),b.getAuthor().getLastName()));

        //9
        int input = Integer.parseInt(scanner.nextLine());
        int result = this.bookService.findTitlesBiggerThan(input);
        System.out.printf("There are %d books with longer title than %d symbols\n", result, input);

    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
