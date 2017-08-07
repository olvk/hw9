package dao;

import lesson9.User;
import lesson9.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DefaultUserDetailsDao implements UserDetailsDao {

    private final SessionFactory factory;
    public DefaultUserDetailsDao(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public UserDetails createUserDetails(int age, String email) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        UserDetails userDetails = new UserDetails();
        userDetails.setAge(age);
        userDetails.setEmail(email);
//        userDetails.setUser(user);

        session.persist(userDetails);
        transaction.commit();
        session.close();
        return userDetails;
    }
}
