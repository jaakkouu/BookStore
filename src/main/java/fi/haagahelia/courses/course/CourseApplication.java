package fi.haagahelia.courses.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.courses.course.model.Book;
import fi.haagahelia.courses.course.model.Category;
import fi.haagahelia.courses.course.dao.BookRepository;
import fi.haagahelia.courses.course.dao.CategoryRepository;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository){
		return (args) -> {
			categoryRepository.save(new Category("Political"));
			categoryRepository.save(new Category("Self-Help"));
			categoryRepository.save(new Category("Food"));
			bookRepository.save(new Book("Jordan Peterson", "978-0-345-81602-3", "29.99", "12 Rules for Life", "2018", categoryRepository.findByName("Self-Help").get(0)));
			bookRepository.save(new Book("Douglas Murray", "978-1-472-94224-1" , "27.99", "Strange Death of Europe", "2017", categoryRepository.findByName("Political").get(0)));
		};
	}

}
