package lesson9;

import lesson9.Post;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USER")
public class User implements Serializable {
    @Id
    @Column(name = "USER_ID", unique = true, nullable = false)
    @SequenceGenerator(name = "user_seq", sequenceName = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    private int userId;

    @Column(name = "LOGIN", unique = true, nullable = false, length = 30)
    private String login;

    @Column(name = "NAME", nullable = false, length = 30)
    private String name;

    @Column(name = "LAST_NAME", nullable = false, length = 30)
    private String lastName;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "user")
    private lesson9.UserDetails details;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;


    public User() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserId() {
        return userId;
    }


    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public UserDetails getDetails() {
        return details;
    }

    public void setDetails(UserDetails details) {
        this.details = details;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "lesson9.User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
