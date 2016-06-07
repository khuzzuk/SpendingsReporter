package pl.spendings.requests.registration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/register")
public class RegisterRequest {
    @RequestMapping(method = RequestMethod.GET)
    public String register(){
        return "registration/register";
    }
}
