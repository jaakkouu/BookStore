package fi.haagahelia.courses.course.dao;

import org.springframework.data.repository.CrudRepository;
import fi.haagahelia.courses.course.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}