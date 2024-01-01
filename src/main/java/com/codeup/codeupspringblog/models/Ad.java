package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "adlister_ads")
public class Ad {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 70)
    private String title;

    @Column(nullable = false, length = 100)
    private String description;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "ads_categories",
            joinColumns = @JoinColumn(name = "ad_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
//    best practice to use sets
    private Set<Category> categories;


    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }
    public Ad(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
    }
}
