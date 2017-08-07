package ut;
import dao.DefaultCommentDao;
import lesson9.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CommentDaoUT {
    @Mock
    SessionFactory factory;

    @Mock
    Session session;

    @Mock
    Transaction transaction;

    DefaultCommentDao dao;
    @Before
    public void setup() {
        dao = new DefaultCommentDao(factory);
        when(factory.openSession()).thenReturn(session);
        when(session.beginTransaction()).thenReturn(transaction);

    }

    @Test
    public void testCreateComment() {
        Comment comment = dao.createComment("I am not throwing away my shot", new Date());
        assertNotNull(comment);
        assertEquals("I am not throwing away my shot", comment.getText());
        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(comment);
        verify(transaction).commit();
        verify(session).close();
    }

}
