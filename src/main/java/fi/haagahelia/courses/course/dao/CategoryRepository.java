package fi.haagahelia.courses.course.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.courses.course.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findByName(String name);
}