package exercises.repositories;

import exercises.entities.Book;
import exercises.entities.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    @Query("select b.title FROM Book as b WHERE b.title=:dependency")
    List<String> findBooksTitleByAgeRestrict(String dependency);

    List<Book> findByEditionTypeAndCopiesLessThan(EditionType gold, int count);

    List<Book> findByPriceLessThanOrPriceGreaterThan(BigDecimal low, BigDecimal high);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate one, LocalDate two);

    List<Book> findByTitleContainingIgnoreCase(String letters);

    List<Book> findByAuthorLastNameStartsWith(String input);

    @Query("SELECT count(b.title) FROM Book as b WHERE length(b.title)>:input")
    int findBooksTitleBiggerThan(int input);
}
