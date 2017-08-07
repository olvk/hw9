package lesson9;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @Column(name = "CATEGORY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    @Column(name = "NAME")
    private String name;

    @ManyToMany
    @JoinTable(name = "POST_CATEGORY", joinColumns = @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "POST_ID")
    )
    private Set<Post> posts;

    public Category() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
