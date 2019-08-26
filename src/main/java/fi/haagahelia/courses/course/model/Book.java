package fi.haagahelia.courses.course.model;

public class Book {
    
    private String title,
        author,
        year,
        isbn,
        price;

    public Book(){
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