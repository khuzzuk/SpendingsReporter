package pl.spendings.users;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.spendings.database.UsersDAO;

import javax.persistence.EntityExistsException;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserCache {
    private List<User> users = new ArrayList<>();
    @Autowired
    private UsersDAO usersDAO;

    public void addUser(User user) {
        users.add(user);
        try {
            usersDAO.saveUser(user);
        } catch (PersistenceException e) {
            throw new EntityExistsException();
        }
    }

    public User getUser(long id){
        Optional<User> user =  users.stream().filter(u->u.getId()==id).findAny();
        return user.isPresent() ? user.get() : new User();
    }
}
