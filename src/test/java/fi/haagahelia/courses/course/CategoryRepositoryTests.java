package fi.haagahelia.courses.course;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import fi.haagahelia.courses.course.dao.CategoryRepository;
import fi.haagahelia.courses.course.model.Category;

import org.springframework.beans.factory.annotation.Autowired;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByName(){
        
        String name = "Self-Help";
        Category category = repository.findByName(name);

        // Self-Help category found
        assertThat(category).isNotNull();
        
    }
    
}