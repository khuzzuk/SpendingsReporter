package pl.spendings.database;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.spendings.users.User;

@Component
@NoArgsConstructor
public class UsersDAO {
    @Autowired
    private ConnectionHandler connectionHandler;

    public void saveUser(User user) {
        Session session = connectionHandler.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        connectionHandler.closeSession();
    }
}
