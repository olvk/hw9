package it;

import dao.DefaultUserDetailsDao;
import dao.UserDetailsDao;
import lesson9.UserDetails;
import org.junit.Test;
import org.levelup.hibernate.config.HibernateTestConfiguration;

import static org.junit.Assert.*;

public class UserDetailsDaoIT {

    UserDetailsDao dao = new DefaultUserDetailsDao(HibernateTestConfiguration.getFactory());

    @Test
    public void testCreateUserDetails() {
        UserDetails userDetails = dao.createUserDetails(17, "koDJF@smth.co");
        assertNotNull(userDetails);
        assertEquals(17, userDetails.getAge());
        assertEquals("koDJF@smth.co", userDetails.getEmail());
        assertNotEquals(0, userDetails.getUser());
    }
}
