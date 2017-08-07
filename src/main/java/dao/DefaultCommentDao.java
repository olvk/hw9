package dao;

import lesson9.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

public class DefaultCommentDao implements CommentDao{

    private final SessionFactory factory;

    @Override
    public Comment createComment(String text, Date commentedAt) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Comment comment = new Comment();
        comment.setText(text);
        comment.setCommentedAt(commentedAt);

        session.persist(comment);
        transaction.commit();
        session.close();

        return comment;
    }

    public DefaultCommentDao(SessionFactory factory) {this.factory = factory;


    }
}
