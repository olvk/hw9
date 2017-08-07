package ut;

import dao.DefaultPostDao;

import dao.PostDao;

import lesson9.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PostDaoUT {

    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    PostDao dao;

    @Before
    public void setup() {
        dao = new DefaultPostDao(factory);

        Mockito.when(factory.openSession()).thenReturn(session);
        Mockito.when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testCreatePost(){
        Post post = dao.createPost("The Schyler Sisters", "There\'s nothing like summer in the city", new Date());
        assertNotNull(post);
        assertEquals("The Schyler Sisters", post.getTitle());
        assertEquals("There\'s nothing like summer in the city", post.getText());
        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(post);
        verify(transaction).commit();
        verify(session).close();
    }


}
