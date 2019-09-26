package fi.haagahelia.courses.course;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.matchers.JUnitMatchers.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebLayerTests {
    
    @Autowired
    private MockMvc mockMvc;

    @Autowired
	private WebApplicationContext context;

    // test with user
    @Before
    public void setup() {
      mockMvc = MockMvcBuilders
        .webAppContextSetup(context)
        .defaultRequest(get("/login")
        .with(user("user").password("user").roles("USER")))
        .apply(springSecurity())
        .build();
    }

    // Testing if correct book page is shown
    @Test
    public void showBook() throws Exception {
        this.mockMvc.perform(get("/book/4")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(CoreMatchers.containsString("12 Rules for Life")));
    }

    // Testing if page found and correct content is show (in this case just the title)
    @Test
    public void showBooks() throws Exception {
        this.mockMvc.perform(get("/booklist"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(CoreMatchers.containsString("Books")));
    }
    
}