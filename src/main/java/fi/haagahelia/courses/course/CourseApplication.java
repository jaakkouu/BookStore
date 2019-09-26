package fi.haagahelia.courses.course;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.courses.course.model.*;
import fi.haagahelia.courses.course.dao.*;

@SpringBootApplication
public class CourseApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository bookRepository, CategoryRepository categoryRepository, UserRepository userRepository){
		return (args) -> {
			userRepository.save(new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER"));
			userRepository.save(new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			categoryRepository.save(new Category("Political"));
			categoryRepository.save(new Category("Self-Help"));
			categoryRepository.save(new Category("Food"));
			bookRepository.save(new Book("Jordan Peterson", "978-0-345-81602-3", "29.99", "12 Rules for Life", "2018", categoryRepository.findByName("Self-Help")));
			bookRepository.save(new Book("Douglas Murray", "978-1-472-94224-1" , "27.99", "Strange Death of Europe", "2017", categoryRepository.findByName("Political")));
		};
	}

}
