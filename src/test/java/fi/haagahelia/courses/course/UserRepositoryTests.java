package fi.haagahelia.courses.course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import fi.haagahelia.courses.course.dao.UserRepository;
import fi.haagahelia.courses.course.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
    
    @Autowired
    private UserRepository repository;

    @Test
    public void findUserByName() {
        String name = "user";
        User user = repository.findByUsername(name);
        assertThat(user).isNotNull();
    }

}