package ut;

import dao.DefaultUserDetailsDao;
import dao.UserDetailsDao;
import lesson9.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.levelup.hibernate.config.HibernateTestConfiguration;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsDaoUT {

    @Mock
    SessionFactory factory;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    UserDetailsDao dao;

    @Before
    public void setup(){
        dao = new DefaultUserDetailsDao(factory);
        Mockito.when(factory.openSession()).thenReturn(session);
        Mockito.when(session.beginTransaction()).thenReturn(transaction);

    }

    @Test
    public void testCreateUserDetails(){

        UserDetails userDetails = dao.createUserDetails(20, "r1234@yandex.ru");
        assertNotNull(userDetails);
        assertEquals(20, userDetails.getAge());
        assertEquals("r1234@yandex.ru", userDetails.getEmail());
        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(userDetails);
        verify(transaction).commit();
        verify(session).close();
    }

}
