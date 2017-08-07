package ut;
import dao.CategoryDao;
import dao.DefaultCategoryDao;
import lesson9.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class CategoryDaoUT {
    @Mock
    private SessionFactory factory;

    @Mock
    private Session session;

    @Mock
    private Transaction transaction;

    CategoryDao dao;

    @Before
    public void setup(){
        dao = new DefaultCategoryDao(factory);
        Mockito.when(factory.openSession()).thenReturn(session);
        Mockito.when(session.beginTransaction()).thenReturn(transaction);
    }

    @Test
    public void testCreateCategory(){
        Category category = dao.createCategory("Musicals");
        assertNotNull(category);
        assertEquals("Musicals", category.getName());
        verify(factory).openSession();
        verify(session).beginTransaction();
        verify(session).persist(category);
        verify(transaction).commit();
        verify(session).close();

    }
}
