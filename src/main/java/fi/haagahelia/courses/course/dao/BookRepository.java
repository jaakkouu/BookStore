package fi.haagahelia.courses.course.dao;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.courses.course.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {}