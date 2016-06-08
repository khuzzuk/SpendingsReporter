package pl.spendings.requests.users;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.Test;

public class RegisterControllerTest {
    @Test(groups = "fast")
    public void checkStartingRegistration() throws Exception {
        RegisterController controller = new RegisterController();
        MockMvc mvc = MockMvcBuilders.standaloneSetup(controller).build();
        mvc.perform(MockMvcRequestBuilders.get("/register")).andExpect(MockMvcResultMatchers.view().name("registration/register"));
    }
}