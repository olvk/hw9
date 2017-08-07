package lesson9;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "USER_DETAILS")
public class UserDetails implements Serializable{



    @Column(name = "EMAIL")
    private String email;

    @Column(name = "AGE")
    private int age;

    @Id
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
