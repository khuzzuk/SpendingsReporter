package pl.spendings.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.spendings.messages.ChannelConfiguration;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap modelMap){
        return "home";
    }
}
