package fi.haagahelia.courses.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String title,
        author,
        year,
        isbn,
        price;

    public Book() {
        
    }

    public Book(String author, String isbn, String price, String title, String year){
        super();
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.title = title;
        this.year = year;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getYear() {
        return this.year;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public String getPrice() {
        return this.price;
    }

    public void setId(Long id) {
        this.id = id;
    }   

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setPrice(String price) {
        this.price = price;
    }

  
}