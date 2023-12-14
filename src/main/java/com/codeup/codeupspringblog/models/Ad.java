package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;
import lombok.*;
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


    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
