package dao;

import lesson9.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DefaultCategoryDao implements CategoryDao {

    private final SessionFactory factory;

    public DefaultCategoryDao(SessionFactory factory) {this.factory = factory;}

    @Override
    public Category createCategory(String name) {

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Category category = new Category();
        category.setName(name);

        session.persist(category);
        transaction.commit();
        session.close();
        return category;
    }
}
