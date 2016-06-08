package pl.spendings.users;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserCache {
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(long id){
        return users.stream().filter(u->u.getId()==id).findAny().get();
    }
}
