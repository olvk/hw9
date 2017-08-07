package it;

import dao.DefaultUserDao;
import dao.UserDao;
import lesson9.User;
import org.junit.Before;
import org.junit.Test;
import org.levelup.hibernate.config.HibernateTestConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class UserDaoIT {

    private UserDao dao = new DefaultUserDao(HibernateTestConfiguration.getFactory());

    @Test
    public void testCreate() {
        User user = dao.createUser("AHam", "Alex", "Hamilton");
        assertNotNull(user);
        assertEquals("AHam", user.getLogin());
        assertNotEquals(0, user.getUserId());

    }


}
