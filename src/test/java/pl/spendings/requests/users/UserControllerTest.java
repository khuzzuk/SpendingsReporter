package pl.spendings.requests.users;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.spendings.conf.ServerConfigurationInitializer;
import pl.spendings.users.User;
import pl.spendings.users.UserCache;

import static org.mockito.Mockito.verify;


@WebAppConfiguration
@ContextConfiguration(classes = ServerConfigurationInitializer.class)
public class UserControllerTest extends AbstractTestNGSpringContextTests {
    @Mock
    UserCache cache;

    @BeforeTest
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(groups = "fast")
    public void checkProperRegistration() throws Exception {
        RegisterController controller = new RegisterController();
        UserCachingInterceptor aspect = new UserCachingInterceptor();
        aspect.setCashe(cache);
        User user = new User();
        user.setEmail("adrian@gmail");
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller, aspect).build();
        mvc.perform(MockMvcRequestBuilders.post("/register")
                .param("email", user.getEmail())
                .param("password", "asdasd"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/users/0"));
        //verify(cache, Mockito.atLeastOnce()).addUser(user);
    }
}