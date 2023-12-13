package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "blog_posts")
public class Post {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 256)
    private String title;

    @Column(nullable = false, length = 1024)
    private String body;

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }
}
