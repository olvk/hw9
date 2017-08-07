package it;


import dao.CommentDao;
import dao.DefaultCommentDao;
import lesson9.Comment;
import org.junit.Test;
import org.levelup.hibernate.config.HibernateTestConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

public class CommentDaoIT {
    CommentDao dao = new DefaultCommentDao(HibernateTestConfiguration.getFactory());

    @Test
    public void testCreateComment() {
        Comment comment = dao.createComment("Look around, look around " +
                "at how lucky we are to be alive right now", new Date());
        assertNotNull(comment);
        assertNotNull(comment.getCommentedAt());
        assertNotNull(comment.getCommentId());
        assertEquals("Look around, look around " +
                "at how lucky we are to be alive right now", comment.getText());
    }

}
