package pl.spendings.requests.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.spendings.users.User;
import pl.spendings.users.UserCache;

import javax.persistence.EntityExistsException;
import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private String registerFrom = "users/register", usersPage = "redirect:/users/";
    @Autowired
    UserCache cache;
    @RequestMapping(method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute(new User());
        return "users/register";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String createUser(@Valid User user, Errors errors, Model model){
        if (errors.hasErrors()) return registerFrom;
        try {
            cache.addUser(user);
        } catch (EntityExistsException e) {
            model.addAttribute("RegistrationFailureMessage", "User already exist");
            return registerFrom;
        }
        return usersPage+user.getId();
    }
}
