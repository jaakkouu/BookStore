package fi.haagahelia.courses.course.dao;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.courses.course.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Category findByName(String name);
}