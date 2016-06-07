package pl.spendings.requests;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"/","/home"})
public class HomeRequest {
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap modelMap){
        return "home";
    }
}
