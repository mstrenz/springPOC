package poc.unit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import poc.GreetingController;
import poc.GreetingService;
import poc.TestingController;
import poc.TestingService;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(TestingController.class)
public class TestingMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestingService testing;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {
        when(testing.test()).thenReturn("Hello Mock");
        this.mockMvc.perform(get("/testing")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello Mock")));
    }
}