package it;

import dao.CategoryDao;
import dao.DefaultCategoryDao;
import lesson9.Category;
import org.junit.Test;
import org.levelup.hibernate.config.HibernateTestConfiguration;
import static org.junit.Assert.*;

public class CategoryDaoIT {

    CategoryDao dao = new DefaultCategoryDao(HibernateTestConfiguration.getFactory());

    @Test
    public void testCategoryDao(){
        Category category = dao.createCategory("Songs");
        assertNotNull(category);
        assertEquals("Songs", category.getName());
        assertNotEquals(0, category.getCategoryId());



    }
}
