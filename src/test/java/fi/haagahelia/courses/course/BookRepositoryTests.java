package fi.haagahelia.courses.course;

import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import fi.haagahelia.courses.course.dao.BookRepository;
import fi.haagahelia.courses.course.model.Book;
import fi.haagahelia.courses.course.model.Category;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTests {

    @Autowired
    private BookRepository repository;

    @Test
    public void createBook() {
        Book book = new Book("Jordan Peterson", "978-0-345-81602-3", "29.99", "12 Rules for Life", "2018", new Category("Self-Help"));
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void deleteBook() {
        Book book = new Book("Jordan Peterson", "978-0-345-81602-3", "29.99", "12 Rules for Life", "2018", new Category("Self-Help"));
        repository.save(book);
        repository.deleteById(book.getId());
        
        Optional<Book> bookAfterDelete = repository.findById(book.getId());

        // Checking if bookAfterDelete exists
        assertThat(bookAfterDelete).isEmpty();
    }

    @Test
    public void updateBook() {

        // Add the book first
        Book book = new Book("Jordan Peterson", "978-0-345-81602-3", "29.99", "12 Rules for Life", "2018", new Category("Self-Help"));
        repository.save(book);
        
        String newAuthorName = "Don Johnson";
        
        // Modify and then save again with new author name
        book.setAuthor(newAuthorName);
        repository.save(book);

        // get updated book from db
        Book updateBook = repository.findById(book.getId()).get();

        // check if book author equals to updated value
        assertThat(updateBook.getAuthor()).isEqualTo(newAuthorName);
    }
}