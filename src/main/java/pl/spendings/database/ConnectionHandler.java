package pl.spendings.database;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ConnectionHandler {
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    Session getSession() {
        if (session == null) {
            session = sessionFactory.openSession();
        }
        return session;
    }
    void closeSession(){
        session.close();
        session = null;
    }
}