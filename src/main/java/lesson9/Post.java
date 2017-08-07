package lesson9;

import lesson9.Comment;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "POST")
public class Post {

    @Id
    @Column(name = "POST_ID", nullable = false, unique = true)
    @SequenceGenerator(name = "post_seq", sequenceName = "post_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq")
    private int postId;

    @Column(name = "TITLE", length = 100)
    private String title;

    @Column(name = "TEXT", length = 300)
    private String text;

    @Column(name = "POSTED_AT", nullable = false)
    private Date postedAt;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User author;

    @OneToMany
    @JoinColumn(name = "POST_ID")
    private Set<Comment> comments;

    @ManyToMany(mappedBy = "posts")
    private Set<Category> categories;

    public Post() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPostId() {
        return postId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }
}
