package lesson9;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "COMMENT")
public class Comment {

    @Id
    @Column(name = "COMMENT_ID")
    @SequenceGenerator(name = "comment_seq", sequenceName = "comment_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_seq")
    private int commentId;

    @Column(name = "TEXT", nullable = false, length = 300)
    private String text;

    @Column(name = "COMMENTED_AT", nullable = false)
    private Date commentedAt;

    @ManyToOne
    @JoinColumn(name = "POST_ID")
    private Post commentedPost;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User author;

    public Comment () {}

    public int getCommentId() {
        return commentId;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(Date commentedAt) {
        this.commentedAt = commentedAt;
    }
}
