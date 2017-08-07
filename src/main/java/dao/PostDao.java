package dao;

import lesson9.Post;
import lesson9.User;

import java.util.Date;

public interface PostDao {

    Post createPost(String title, String text, Date postedAt);
}
