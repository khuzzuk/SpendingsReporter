package pl.spendings.requests.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.spendings.users.UserCache;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserCache cache;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable long id, Model model){
        model.addAttribute(cache.getUser(id));
        return "users/profile";
    }
}
