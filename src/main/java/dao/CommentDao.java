package dao;

import lesson9.Comment;

import java.util.Date;

public interface CommentDao {

    public Comment createComment(String text, Date commentedAt);
}
