package com.codeup.codeupspringblog.models;
import jakarta.persistence.*;
import lombok.Getter;


//@Getter
//@Entity
//@Table(name = "adlister_ads")
public class Ad {
    private long id;
    private String title;
    private String description;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public void setId(long id) {
        this.id = id;
    }

//    @Column(nullable = false, length = 256)
    public void setTitle(String title) {
        this.title = title;
    }

//    @Column(nullable = false, length = 1024)
    public void setDescription(String description) {
        this.description = description;
    }

    public Ad() {
    }

    public Ad(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
