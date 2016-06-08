package pl.spendings.requests.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.spendings.users.User;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserCachingInterceptor interceptor;
    @RequestMapping(method = RequestMethod.GET)
    public String register(){
        return "users/register";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String createUser(User user){
        return "redirect:/users/"+user.getId();
    }
}
