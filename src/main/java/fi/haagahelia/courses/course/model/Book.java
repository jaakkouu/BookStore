package fi.haagahelia.courses.course.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {
        
    }

    public Book(String author, String isbn, String price, String title, String year, Category category){
        super();
        setAuthor(author);
        setIsbn(isbn);
        setPrice(price);
        setTitle(title);
        setYear(year);
        setCategory(category);
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

    public Category getCategory(){
        return this.category;
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

    public void setCategory(Category category){
        this.category = category;
    }

  
}