package ut;

import dao.DefaultUserDao;
import dao.UserDao;
import lesson9.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    private UserDao dao;

    @Before
    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        factory = Mockito.mock(SessionFactory.class);
        dao = new DefaultUserDao(factory);

        Mockito.when(factory.openSession()).thenReturn(session);
        Mockito.when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void  testCreate() {
        User user = dao.createUser("AHam", "Alex", "Hamilton");
        assertNotNull(user);
        assertEquals("AHam", user.getLogin());
        assertEquals("Alex", user.getName());
        assertEquals("Hamilton", user.getLastName());

        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(any(User.class));
        verify(transaction).commit();
        verify(session).close();
    }

}
