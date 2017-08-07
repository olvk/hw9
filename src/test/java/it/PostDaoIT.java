package it;

import dao.DefaultPostDao;
import dao.PostDao;
import lesson9.Post;
import org.junit.Assert;
import org.junit.Test;
import org.levelup.hibernate.config.HibernateTestConfiguration;

import java.util.Date;

import static org.junit.Assert.*;

public class PostDaoIT {

    private PostDao dao = new DefaultPostDao(HibernateTestConfiguration.getFactory());

    @Test
    public void testCreatePost (){

        Post post = dao.createPost("Helpless", "I remember that night", new Date());
        assertNotNull(post);
        assertNotNull(post.getPostedAt());
        assertEquals("Helpless", post.getTitle() );
        assertEquals("I remember that night", post.getText() );
        assertNotEquals(0, post.getPostId());
    }
}
