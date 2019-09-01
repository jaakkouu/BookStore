package fi.haagahelia.courses.course.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long categoryId;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Book> books;

    public Category() {
        
    }

    public Category(String name){
        super();
        setName(name);
    }

    public Long getId() {
        return this.categoryId;
    }

    public String getName() {
        return this.name;
    }

    public List<Book> getBooks(){
        return this.books;
    }

    public void setId(Long categoryId) {
        this.categoryId = categoryId;
    }   

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books){
        this.books = books;
    }

  
}