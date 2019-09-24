package fi.haagahelia.courses.course.dao;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.courses.course.model.EndUser;

public interface EndUserRepository extends CrudRepository<EndUser, Long> {}