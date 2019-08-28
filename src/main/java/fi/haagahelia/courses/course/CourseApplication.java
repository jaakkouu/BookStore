package fi.haagahelia.courses.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.courses.course.model.Book;
import fi.haagahelia.courses.course.model.BookRepository;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository){
		return (args) -> {
			repository.save(new Book("Jordan Peterson", "978-0-345-81602-3", "29.99", "12 Rules for Life", "2018"));
			repository.save(new Book("Douglas Murray", "978-1-472-94224-1" , "27.99", "Strange Death of Europe", "2017"));
		};
	}

}
