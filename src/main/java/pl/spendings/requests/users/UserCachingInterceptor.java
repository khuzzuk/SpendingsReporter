package pl.spendings.requests.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import pl.spendings.users.User;
import pl.spendings.users.UserCache;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class UserCachingInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private UserCache cache;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Map<String, Object> model = modelAndView.getModel();
        if (model.containsKey("user")){
            cache.addUser((User) model.get("user"));
            System.out.println("INTERCEPTED");
        }
    }

    public void setCashe(UserCache cashe) {
        this.cache = cashe;
    }
}